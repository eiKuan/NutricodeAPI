package com.tg.nutricode.dto;

public record UserProgressionProfileResponseDto(
    long xp,
    int level,
    long nextLevelRequirement,  // XP necessário para o próximo nível
    long currentReward,         // Recompensa base atual de XP
    int currentWorkoutStreak,
    int longestWorkoutStreak,
    int currentDietStreak,
    int longestDietStreak,
    int currentWaterStreak,
    int longestWaterStreak
) {
    
}
