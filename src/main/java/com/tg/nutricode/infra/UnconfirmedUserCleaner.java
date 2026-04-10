package com.tg.nutricode.infra;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.tg.nutricode.repository.UserRepository;
import com.tg.nutricode.repository.UserTokenRepository;

//Para deletar usuarios n confirmados no bd
@Component
public class UnconfirmedUserCleaner {

    private final UserRepository userRepository;
    private final UserTokenRepository userTokenRepository;

    public UnconfirmedUserCleaner(UserRepository userRepository,
                                   UserTokenRepository userTokenRepository) {
        this.userRepository = userRepository;
        this.userTokenRepository = userTokenRepository;
    }

    @Scheduled(fixedRate = 1800000)
    @Transactional
    public void deleteUnconfirmedUsers() {
        Instant limit = Instant.now().minus(1, ChronoUnit.HOURS);

        // deleta tokens primeiro, depois os usuários
        userTokenRepository.deleteTokensOfUnconfirmedUsersBefore(limit);
        userRepository.deleteUnconfirmedBefore(limit);

        System.out.println("Limpeza de usuários não confirmados executada: " + Instant.now());
    }
}