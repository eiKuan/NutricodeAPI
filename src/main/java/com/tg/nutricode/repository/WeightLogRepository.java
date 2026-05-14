package com.tg.nutricode.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.tg.nutricode.model.WeightLog;
import com.tg.nutricode.model.WeightLogId;

@Repository
public interface WeightLogRepository extends JpaRepository<WeightLog, WeightLogId> {

    // todos os logs do usuário
    List<WeightLog> findByUser_UserIdOrderByDateDesc(String userId);

    // último log do usuário
    Optional<WeightLog> findFirstByUser_UserIdOrderByDateDesc(String userId);

    // logs do último mês
    @Query("SELECT w FROM WeightLog w WHERE w.user.userId = :userId AND w.date >= :startDate ORDER BY w.date DESC")
    List<WeightLog> findLastMonthByUserId(@Param("userId") String userId, @Param("startDate") LocalDate startDate);

    // buscar por userId e date (para o upsert)
    Optional<WeightLog> findByUser_UserIdAndDate(String userId, LocalDate date);
}