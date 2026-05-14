package com.tg.nutricode.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tg.nutricode.model.WorkoutPerformed;
import com.tg.nutricode.model.WorkoutPerformedId;
import java.time.LocalDate;

@Repository
public interface WorkoutPerformedRepository extends JpaRepository<WorkoutPerformed, WorkoutPerformedId> {

    List<WorkoutPerformed> findByUser_UserIdOrderByDateDesc(String userId);

    Optional<WorkoutPerformed> findFirstByUser_UserIdOrderByDateDesc(String userId);

    Optional<WorkoutPerformed> findByUser_UserIdAndDate(String userId, LocalDate date);
}