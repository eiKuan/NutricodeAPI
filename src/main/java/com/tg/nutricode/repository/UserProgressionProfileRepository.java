package com.tg.nutricode.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tg.nutricode.model.UserProgressionProfile;

@Repository
public interface UserProgressionProfileRepository extends JpaRepository<UserProgressionProfile, String> {

    Optional<UserProgressionProfile> findByUser_UserId(String userId);
}