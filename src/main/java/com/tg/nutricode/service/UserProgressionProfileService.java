package com.tg.nutricode.service;

import org.springframework.stereotype.Service;

import com.tg.nutricode.dto.UserProgressionProfileResponseDto;
import com.tg.nutricode.model.UserProgressionProfile;
import com.tg.nutricode.repository.UserProgressionProfileRepository;

@Service
public class UserProgressionProfileService {

    private final UserProgressionProfileRepository repository;
    private final ProgressionCalculator progressionCalculator;

    public UserProgressionProfileService(UserProgressionProfileRepository repository,
                                          ProgressionCalculator progressionCalculator) {
        this.repository = repository;
        this.progressionCalculator = progressionCalculator;
    }

    public UserProgressionProfileResponseDto findByUserId(String userId) {
        return repository.findByUser_UserId(userId)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Progression profile not found"));
    }

    private UserProgressionProfileResponseDto toDto(UserProgressionProfile profile) {
        long nextLevelRequirement = progressionCalculator
                .calculateNextLevelRequirement(profile.getLevel());
        long currentReward = progressionCalculator
                .calculateBaseWorkoutDietReward(profile.getLevel());

        return new UserProgressionProfileResponseDto(
            profile.getXp(),
            profile.getLevel(),
            nextLevelRequirement,
            currentReward,
            profile.getCurrentWorkoutStreak(),
            profile.getLongestWorkoutStreak(),
            profile.getCurrentDietStreak(),
            profile.getLongestDietStreak(),
            profile.getCurrentWaterStreak(),
            profile.getLongestWaterStreak()
        );
    }
}