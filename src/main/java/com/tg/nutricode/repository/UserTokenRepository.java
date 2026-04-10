package com.tg.nutricode.repository;

import java.time.Instant;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tg.nutricode.model.UserToken;

@Repository
public interface UserTokenRepository extends JpaRepository<UserToken, String> {

    Optional<UserToken> findByConfirmationToken(String confirmationToken);

    Optional<UserToken> findByPasswordResetToken(String passwordResetToken);

    Optional<UserToken> findByRefreshToken(String refreshToken);

    Optional<UserToken> findByUser_UserId(String userId);

    //Limpar usuarios nao confirmados no bd
    @Modifying
    @Transactional
    @Query("DELETE FROM UserToken ut WHERE ut.user.emailConfirmed = false AND ut.user.creationTimestamp < :limit")
    void deleteTokensOfUnconfirmedUsersBefore(@Param("limit") Instant limit);
}