package com.tg.nutricode.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tg.nutricode.dto.WaterLogRequestDto;
import com.tg.nutricode.dto.WaterLogResponseDto;
import com.tg.nutricode.model.User;
import com.tg.nutricode.model.UserProgressionProfile;
import com.tg.nutricode.model.WaterLog;
import com.tg.nutricode.repository.UserProgressionProfileRepository;
import com.tg.nutricode.repository.UserRepository;
import com.tg.nutricode.repository.WaterLogRepository;

@Service
public class WaterLogService {

    private final WaterLogRepository waterLogRepository;
    private final UserRepository userRepository;
    private final UserProgressionProfileRepository progressionRepository;
    private final ProgressionCalculator progressionCalculator;

    public WaterLogService(WaterLogRepository waterLogRepository,
                           UserRepository userRepository,
                           UserProgressionProfileRepository progressionRepository,
                           ProgressionCalculator progressionCalculator) {
        this.waterLogRepository = waterLogRepository;
        this.userRepository = userRepository;
        this.progressionRepository = progressionRepository;
        this.progressionCalculator = progressionCalculator;
    }

    @Transactional
    public WaterLogResponseDto save(String userId, WaterLogRequestDto dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        WaterLog waterLog = waterLogRepository
                .findByUser_UserIdAndDate(userId, dto.date())
                .orElse(new WaterLog(user, dto.date(), dto.milliliters()));

        waterLog.setMilliliters(dto.milliliters());
        waterLog.setCompleted(dto.isCompleted());
        waterLogRepository.save(waterLog);

        UserProgressionProfile profile = progressionRepository.findByUser_UserId(userId)
                .orElseThrow(() -> new RuntimeException("Progression profile not found"));

        long xpEarned = progressionCalculator.updateWaterStreakAndApplyXp(profile, dto.isCompleted());

        return toDto(waterLog, xpEarned);
    }

    public List<WaterLogResponseDto> findAll(String userId) {
        return waterLogRepository.findByUser_UserIdOrderByDateDesc(userId)
                .stream()
                .map(w -> toDto(w, 0))
                .toList();
    }

    public Optional<WaterLogResponseDto> findLatest(String userId) {
        return waterLogRepository.findFirstByUser_UserIdOrderByDateDesc(userId)
                .map(w -> toDto(w, 0));
    }

    public List<WaterLogResponseDto> findLastMonth(String userId) {
        LocalDate startDate = LocalDate.now().minusDays(30);
        return waterLogRepository.findLastMonthByUserId(userId, startDate)
                .stream()
                .map(w -> toDto(w, 0))
                .toList();
    }

    private WaterLogResponseDto toDto(WaterLog log, long xpEarned) {
        return new WaterLogResponseDto(
            log.getMilliliters(),
            log.getDate(),
            log.isCompleted(),
            xpEarned
        );
    }
}