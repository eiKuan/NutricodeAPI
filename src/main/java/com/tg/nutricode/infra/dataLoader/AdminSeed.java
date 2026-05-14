package com.tg.nutricode.infra.dataLoader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.tg.nutricode.model.Role;
import com.tg.nutricode.model.User;
import com.tg.nutricode.model.UserInfo;
import com.tg.nutricode.model.UserProgressionProfile;
import com.tg.nutricode.model.UserToken;
import com.tg.nutricode.repository.UserInfoRepository;
import com.tg.nutricode.repository.UserProgressionProfileRepository;
import com.tg.nutricode.repository.UserRepository;
import com.tg.nutricode.repository.UserTokenRepository;

//Gerar um adm

@Component
public class AdminSeed implements ApplicationRunner {

    private final UserRepository userRepository;
    private final UserTokenRepository userTokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserProgressionProfileRepository userProgressionProfileRepository;
    private final UserInfoRepository userInfoRepository;

    @Value("${admin.email}")
    private String adminEmail;

    @Value("${admin.password}")
    private String adminPassword;

    @Value("${admin.username}")
    private String adminUsername;

    public AdminSeed(UserRepository userRepository,
                     UserTokenRepository userTokenRepository,
                     PasswordEncoder passwordEncoder,
                     UserProgressionProfileRepository userProgressionProfileRepository,
                     UserInfoRepository userInfoRepository) {
        this.userRepository = userRepository;
        this.userTokenRepository = userTokenRepository;
        this.passwordEncoder = passwordEncoder;
        this.userProgressionProfileRepository = userProgressionProfileRepository;
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // verifica se o admin já existe
        if (userRepository.findByEmail(adminEmail).isPresent()) {
            return;
        }

        User admin = new User();
        admin.setUsername(adminUsername);
        admin.setEmail(adminEmail);
        admin.setPassword(passwordEncoder.encode(adminPassword));
        admin.setRole(Role.ADMIN);
        admin.setEmailConfirmed(true); // admin não precisa confirmar email
        userRepository.save(admin);

        // cria o UserToken para o admin
        UserToken adminToken = new UserToken(admin);
        userTokenRepository.save(adminToken);

        UserInfo adminInfo = new UserInfo(admin);
        userInfoRepository.save(adminInfo);

        UserProgressionProfile progressionProfile = new UserProgressionProfile(admin);
        userProgressionProfileRepository.save(progressionProfile);

        System.out.println("Admin criado com sucesso: " + adminEmail);
    }
}