package com.tg.nutricode.controller;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tg.nutricode.dto.ForgotPasswordRequestDto;
import com.tg.nutricode.dto.ForgotPasswordResponseDto;
import com.tg.nutricode.dto.LoginRequestDto;
import com.tg.nutricode.dto.RefreshRequestDto;
import com.tg.nutricode.dto.RegisterRequestDto;
import com.tg.nutricode.dto.RegisterResponseDto;
import com.tg.nutricode.dto.ResetPasswordRequestDto;
import com.tg.nutricode.dto.ResponseDto;
import com.tg.nutricode.model.User;
import com.tg.nutricode.model.UserInfo;
import com.tg.nutricode.model.UserProgressionProfile;
import com.tg.nutricode.model.UserToken;
import com.tg.nutricode.repository.UserInfoRepository;
import com.tg.nutricode.repository.UserProgressionProfileRepository;
import com.tg.nutricode.repository.UserRepository;
import com.tg.nutricode.repository.UserTokenRepository;
import com.tg.nutricode.service.ConfirmationTokenService;
import com.tg.nutricode.service.TokenService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
@Tag(
    name = "0 - Autenticação | ",
    description = "Endpoints de autenticação. Login, registro, confirmação de email, refresh, logout e recuperação de senha."
)
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserTokenRepository userTokenRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private ConfirmationTokenService confirmationTokenService;
    @Autowired
    private UserProgressionProfileRepository userProgressionProfileRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;


    @Operation(
        summary = "Login",
        description = "Autentica o usuário com email e senha. "
                    + "Retorna o Access Token (válido por 2 horas) e o Refresh Token (válido por 30 dias). "
                    + "O email deve estar confirmado para efetuar login."
    )
    @PostMapping("/login")
    public ResponseEntity<ResponseDto> login(@Valid @RequestBody LoginRequestDto body) {
        User user = userRepository.findByEmail(body.email())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.isEmailConfirmed()) {
            return ResponseEntity.status(403).build();
        }

        if (passwordEncoder.matches(body.password(), user.getPassword())) {
            String token = tokenService.generateToken(user);
            String refreshToken = tokenService.generateRefreshToken(user);

            UserToken userToken = userTokenRepository.findByUser_UserId(user.getUserId())
                    .orElse(new UserToken(user));
            userToken.setRefreshToken(refreshToken);
            userTokenRepository.save(userToken);

            return ResponseEntity.ok(new ResponseDto(user.getUsername(), token, refreshToken));
        }

        return ResponseEntity.badRequest().build();
    }

    @Operation(
        summary = "Registro",
        description = "Cadastra um novo usuário. "
                    + "Retorna o token de confirmação para o frontend enviar o email via EmailJS. "
                    + "Regras: username (3-20 caracteres, só letras/números/_), "
                    + "senha (mín. 8 caracteres, maiúscula + minúscula + número)."
    )
    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> register(@Valid @RequestBody RegisterRequestDto body) {
        Optional<User> existingUser = userRepository.findByEmail(body.email());

        if (existingUser.isPresent()) {
            User user = existingUser.get();

            if (user.isEmailConfirmed()) {
                return ResponseEntity.badRequest().build();
            }

            // reenvia o confirmation token para o frontend enviar o email
            UserToken userToken = userTokenRepository.findByUser_UserId(user.getUserId())
                    .orElse(new UserToken(user));

            return ResponseEntity.ok(new RegisterResponseDto(
                user.getUsername(),
                user.getEmail(),
                userToken.getConfirmationToken()
            ));
        }

        User newUser = new User();
        newUser.setPassword(passwordEncoder.encode(body.password()));
        newUser.setEmail(body.email());
        newUser.setUsername(body.username());
        newUser.setEmailConfirmed(false);
        userRepository.save(newUser);

        String confirmationToken = confirmationTokenService.generateConfirmationToken();
        String refreshToken = tokenService.generateRefreshToken(newUser);

        UserToken userToken = new UserToken(newUser);
        userToken.setConfirmationToken(confirmationToken);
        userToken.setRefreshToken(refreshToken);
        userTokenRepository.save(userToken);

        //Cria perfil de progresso do usuario
        UserProgressionProfile progressionProfile = new UserProgressionProfile(newUser);
        userProgressionProfileRepository.save(progressionProfile);

        UserInfo userInfo = new UserInfo(newUser);
        userInfoRepository.save(userInfo);
        // retorna o token para o frontend enviar o email via EmailJS
        return ResponseEntity.ok(new RegisterResponseDto(
            newUser.getUsername(),
            newUser.getEmail(),
            confirmationToken
        ));
    }

    @Operation(
        summary = "Confirmar Email",
        description = "Ativa a conta do usuário a partir do token enviado pelo frontend via EmailJS. "
                    + "O token expira em 24 horas."
    )
    @GetMapping("/confirm")
    public ResponseEntity<String> confirmEmail(@RequestParam String token) {
        UserToken userToken = userTokenRepository.findByConfirmationToken(token)
                .orElseThrow(() -> new RuntimeException("Token inválido ou expirado"));

        User user = userToken.getUser();

        if (user.isEmailConfirmed()) {
            return ResponseEntity.ok("Email já confirmado!");
        }

        user.setEmailConfirmed(true);
        userRepository.save(user);

        userToken.setConfirmationToken(null);
        userTokenRepository.save(userToken);

        return ResponseEntity.ok("Email confirmado com sucesso! Faça login para continuar.");
    }

    @Operation(
        summary = "Refresh Token",
        description = "Gera um novo Access Token a partir do Refresh Token."
    )
    @PostMapping("/refresh")
    public ResponseEntity<ResponseDto> refresh(@RequestBody RefreshRequestDto body) {
        String email = tokenService.validateToken(body.refreshToken());

        if (email == null) {
            return ResponseEntity.badRequest().build();
        }

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserToken userToken = userTokenRepository.findByUser_UserId(user.getUserId())
                .orElseThrow(() -> new RuntimeException("Token not found"));

        if (!body.refreshToken().equals(userToken.getRefreshToken())) {
            return ResponseEntity.badRequest().build();
        }

        String newToken = tokenService.generateToken(user);
        String newRefreshToken = tokenService.generateRefreshToken(user);
        userToken.setRefreshToken(newRefreshToken);
        userTokenRepository.save(userToken);

        return ResponseEntity.ok(new ResponseDto(user.getUsername(), newToken, newRefreshToken));
    }

    @Operation(
        summary = "Logout",
        description = "Encerra a sessão invalidando o Refresh Token no banco."
    )
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody RefreshRequestDto body) {
        String email = tokenService.validateToken(body.refreshToken());

        if (email != null) {
            User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            userTokenRepository.findByUser_UserId(user.getUserId())
                    .ifPresent(userToken -> {
                        userToken.setRefreshToken(null);
                        userTokenRepository.save(userToken);
                    });
        }

        return ResponseEntity.noContent().build();
    }

    @Operation(
        summary = "Esqueci minha senha",
        description = "Gera um token de recuperação de senha. "
                    + "Retorna o token para o frontend enviar o email via EmailJS."
    )
    @PostMapping("/forgot-password")
    public ResponseEntity<ForgotPasswordResponseDto> forgotPassword(
            @Valid @RequestBody ForgotPasswordRequestDto body) {

        User user = userRepository.findByEmail(body.email())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String resetToken = confirmationTokenService.generateConfirmationToken();

        UserToken userToken = userTokenRepository.findByUser_UserId(user.getUserId())
                .orElse(new UserToken(user));
        userToken.setPasswordResetToken(resetToken);
        userToken.setPasswordResetExpiry(Instant.now().plus(1, ChronoUnit.HOURS));
        userTokenRepository.save(userToken);

        // retorna o token para o frontend enviar o email via EmailJS
        return ResponseEntity.ok(new ForgotPasswordResponseDto(
            user.getUsername(),
            user.getEmail(),
            resetToken
        ));
    }

    @Operation(
        summary = "Redefinir senha",
        description = "Redefine a senha do usuário a partir do token recebido pelo EmailJS."
    )
    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@Valid @RequestBody ResetPasswordRequestDto body) {
        UserToken userToken = userTokenRepository.findByPasswordResetToken(body.token())
                .orElseThrow(() -> new RuntimeException("Token inválido ou expirado"));

        if (userToken.getPasswordResetExpiry().isBefore(Instant.now())) {
            return ResponseEntity.badRequest().body("Token expirado!");
        }

        User user = userToken.getUser();
        user.setPassword(passwordEncoder.encode(body.newPassword()));
        userRepository.save(user);

        userToken.setPasswordResetToken(null);
        userToken.setPasswordResetExpiry(null);
        userTokenRepository.save(userToken);

        return ResponseEntity.ok("Senha redefinida com sucesso! Faça login para continuar.");
    }
}