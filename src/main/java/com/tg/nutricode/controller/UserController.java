package com.tg.nutricode.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tg.nutricode.dto.UpdateUserDto;
import com.tg.nutricode.dto.UserResponseDto;
import com.tg.nutricode.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
@SecurityRequirement(name = "bearerAuth")
@Tag(
    name = "Usuários | ",
    description = "Gerenciamento de usuários autenticados. Todos os endpoints requerem token JWT válido."
)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(
        summary = "Buscar usuário por ID",
        description = "Retorna os dados de um usuário específico pelo ID. "
                    + "A senha nunca é retornada por segurança."
    )
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable String userId) {
        return userService.getUserById(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
        summary = "Listar todos os usuários",
        description = "Retorna a lista completa de usuários cadastrados. "
                    + "A senha nunca é retornada por segurança."
    )
    @GetMapping("/list")
    public ResponseEntity<List<UserResponseDto>> listUsers() {
        return ResponseEntity.ok(userService.listUsers());
    }

    @Operation(
        summary = "Atualizar usuário",
        description = "Atualiza o username e/ou senha do usuário. "
                    + "Ambos os campos são opcionais — envie apenas o que deseja alterar. "
                    + "Regras: username (3-20 caracteres, só letras/números/_), "
                    + "senha (mín. 8 caracteres, maiúscula + minúscula + número)."
    )
    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateUserById(
            @PathVariable String userId,
            @Valid @RequestBody UpdateUserDto updateUserDto) {
        userService.updateUserById(userId, updateUserDto);
        return ResponseEntity.noContent().build();
    }

    @Operation(
        summary = "Deletar usuário",
        description = "Remove permanentemente o usuário do banco de dados. "
                    + "Esta ação não pode ser desfeita."
    )
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteById(@PathVariable String userId) {
        userService.deleteById(userId);
        return ResponseEntity.noContent().build();
    }
}