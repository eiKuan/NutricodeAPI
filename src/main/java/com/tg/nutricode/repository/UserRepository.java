package com.tg.nutricode.repository;

import java.time.Instant;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tg.nutricode.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByEmail(String email);

    // Limpar usuarios (UserToken vem antes) não confirmados no bd
    @Modifying
    @Transactional
    @Query("DELETE FROM User u WHERE u.emailConfirmed = false AND u.creationTimestamp < :limit")
    void deleteUnconfirmedBefore(@Param("limit") Instant limit);
}