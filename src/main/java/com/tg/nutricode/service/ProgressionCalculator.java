package com.tg.nutricode.service;

import org.springframework.stereotype.Service;

import com.tg.nutricode.model.UserProgressionProfile;
import com.tg.nutricode.repository.UserProgressionProfileRepository;

@Service
public class ProgressionCalculator {

    private final UserProgressionProfileRepository progressionRepository;

    public ProgressionCalculator(UserProgressionProfileRepository progressionRepository) {
        this.progressionRepository = progressionRepository;
    }

    // XP necessário para o próximo nível
    public long calculateNextLevelRequirement(int level) {
        return 240L * (level + 1);
    }

    // Recompensa base de XP para workout e diet
    public long calculateBaseWorkoutDietReward(int level) {
        return (level * 10L) + 100;
    }

    // Recompensa base de XP para água
    public long calculateBaseWaterReward(int level) {
        return 50 + (level * 10L);
    }

    // Bônus de streak para workout/diet
    public long calculateStreakBonus(long baseReward, int currentWorkoutStreak,
            int currentDietStreak, boolean isWorkout) {

        boolean workoutHasBonus = currentWorkoutStreak >= 7;
        boolean dietHasBonus = currentDietStreak >= 7;
        boolean bothHaveBonus = workoutHasBonus && dietHasBonus;
        boolean thisPlaneHasBonus = isWorkout ? workoutHasBonus : dietHasBonus;

        if (!thisPlaneHasBonus) return 0;

        double multiplier = bothHaveBonus ? 0.15 : 0.10;
        long bonus = (long) Math.floor(baseReward * multiplier);
        long remainder = bonus % 10;
        return bonus - remainder;
    }

    // Bônus de streak para água
    public long calculateWaterStreakBonus(long baseReward, int currentWaterStreak) {
        if (currentWaterStreak < 7) return 0;
        long bonus = (long) Math.floor(baseReward * 0.10);
        long remainder = bonus % 10;
        return bonus - remainder;
    }

    // Aplica o XP e sobe de nível se necessário
    public void applyXp(UserProgressionProfile profile, long xpEarned) {
        long currentXp = profile.getXp() + xpEarned;
        int currentLevel = profile.getLevel();

        long nextLevelRequirement = calculateNextLevelRequirement(currentLevel);

        while (currentXp >= nextLevelRequirement) {
            currentXp -= nextLevelRequirement;
            currentLevel++;
            nextLevelRequirement = calculateNextLevelRequirement(currentLevel);
        }

        profile.setXp(currentXp);
        profile.setLevel(currentLevel);
        progressionRepository.save(profile);
    }

    // Calcula a recompensa total de workout/diet e aplica
    public long calculateAndApplyWorkoutDietXp(UserProgressionProfile profile, boolean isWorkout) {
        long baseReward = calculateBaseWorkoutDietReward(profile.getLevel());
        long bonus = calculateStreakBonus(
                baseReward,
                profile.getCurrentWorkoutStreak(),
                profile.getCurrentDietStreak(),
                isWorkout
        );
        long totalReward = baseReward + bonus;
        applyXp(profile, totalReward);
        return totalReward;
    }

    // Calcula a recompensa total de água e aplica
    public long calculateAndApplyWaterXp(UserProgressionProfile profile) {
        long baseReward = calculateBaseWaterReward(profile.getLevel());
        long bonus = calculateWaterStreakBonus(baseReward, profile.getCurrentWaterStreak());
        long totalReward = baseReward + bonus;
        applyXp(profile, totalReward);
        return totalReward;
    }

    // Atualiza streak de workout e aplica XP
    public long updateWorkoutStreakAndApplyXp(UserProgressionProfile profile, boolean isFinished) {
        if (!isFinished) {
            profile.setCurrentWorkoutStreak(0);
            progressionRepository.save(profile);
            return 0;
        }

        int newStreak = profile.getCurrentWorkoutStreak() + 1;
        profile.setCurrentWorkoutStreak(newStreak);
        if (newStreak > profile.getLongestWorkoutStreak()) {
            profile.setLongestWorkoutStreak(newStreak);
        }
        progressionRepository.save(profile);

        return calculateAndApplyWorkoutDietXp(profile, true);
    }

    // Atualiza streak de diet e aplica XP
    public long updateDietStreakAndApplyXp(UserProgressionProfile profile, boolean isFinished) {
        if (!isFinished) {
            profile.setCurrentDietStreak(0);
            progressionRepository.save(profile);
            return 0;
        }

        int newStreak = profile.getCurrentDietStreak() + 1;
        profile.setCurrentDietStreak(newStreak);
        if (newStreak > profile.getLongestDietStreak()) {
            profile.setLongestDietStreak(newStreak);
        }
        progressionRepository.save(profile);

        return calculateAndApplyWorkoutDietXp(profile, false);
    }

    // Atualiza streak de água e aplica XP
    public long updateWaterStreakAndApplyXp(UserProgressionProfile profile, boolean isCompleted) {
        if (!isCompleted) {
            profile.setCurrentWaterStreak(0);
            progressionRepository.save(profile);
            return 0;
        }

        int newStreak = profile.getCurrentWaterStreak() + 1;
        profile.setCurrentWaterStreak(newStreak);
        if (newStreak > profile.getLongestWaterStreak()) {
            profile.setLongestWaterStreak(newStreak);
        }
        progressionRepository.save(profile);

        return calculateAndApplyWaterXp(profile);
    }
}