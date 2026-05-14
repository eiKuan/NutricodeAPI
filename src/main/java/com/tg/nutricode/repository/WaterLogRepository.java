package com.tg.nutricode.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.tg.nutricode.model.WaterLog;
import com.tg.nutricode.model.WaterLogId;

@Repository
public interface WaterLogRepository extends JpaRepository<WaterLog, WaterLogId> {

    List<WaterLog> findByUser_UserIdOrderByDateDesc(String userId);

    Optional<WaterLog> findFirstByUser_UserIdOrderByDateDesc(String userId);

    Optional<WaterLog> findByUser_UserIdAndDate(String userId, LocalDate date);

    @Query("SELECT w FROM WaterLog w WHERE w.user.userId = :userId AND w.date >= :startDate ORDER BY w.date DESC")
    List<WaterLog> findLastMonthByUserId(@Param("userId") String userId,
                                         @Param("startDate") LocalDate startDate);
}