package com.tg.nutricode.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tg.nutricode.model.DietPerformed;
import com.tg.nutricode.model.DietPerformedId;
import java.time.LocalDate;

@Repository
public interface DietPerformedRepository extends JpaRepository<DietPerformed, DietPerformedId> {

    List<DietPerformed> findByUser_UserIdOrderByDateDesc(String userId);

    Optional<DietPerformed> findFirstByUser_UserIdOrderByDateDesc(String userId);

    Optional<DietPerformed> findByUser_UserIdAndDate(String userId, LocalDate date);
}