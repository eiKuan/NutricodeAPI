package com.tg.nutricode.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_progression_profile")
public class UserProgressionProfile {

    @Id
    private String userId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    // Gamificação
    @Column(name = "xp")
    private long xp = 0;

    @Column(name = "level")
    private int level = 1;

    // Streaks de treino
    @Column(name = "current_workout_streak")
    private int currentWorkoutStreak = 0;

    @Column(name = "longest_workout_streak")
    private int longestWorkoutStreak = 0;

    // Streaks de dieta
    @Column(name = "current_diet_streak")
    private int currentDietStreak = 0;

    @Column(name = "longest_diet_streak")
    private int longestDietStreak = 0;

    // Streaks de água
    @Column(name = "current_water_streak")
    private int currentWaterStreak = 0;

    @Column(name = "longest_water_streak")
    private int longestWaterStreak = 0;


    // // //// ///// // //// //// // //// //////
    // Getters e Setters

    public UserProgressionProfile() {
    }

    public UserProgressionProfile(User user) {
        this.user = user;
    }

    public String getUserId() {
        return userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getXp() {
        return xp;
    }

    public void setXp(long xp) {
        this.xp = xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCurrentWorkoutStreak() {
        return currentWorkoutStreak;
    }

    public void setCurrentWorkoutStreak(int currentWorkoutStreak) {
        this.currentWorkoutStreak = currentWorkoutStreak;
    }

    public int getLongestWorkoutStreak() {
        return longestWorkoutStreak;
    }

    public void setLongestWorkoutStreak(int longestWorkoutStreak) {
        this.longestWorkoutStreak = longestWorkoutStreak;
    }

    public int getCurrentDietStreak() {
        return currentDietStreak;
    }

    public void setCurrentDietStreak(int currentDietStreak) {
        this.currentDietStreak = currentDietStreak;
    }

    public int getLongestDietStreak() {
        return longestDietStreak;
    }

    public void setLongestDietStreak(int longestDietStreak) {
        this.longestDietStreak = longestDietStreak;
    }

    public int getCurrentWaterStreak() {
        return currentWaterStreak;
    }

    public void setCurrentWaterStreak(int currentWaterStreak) {
        this.currentWaterStreak = currentWaterStreak;
    }

    public int getLongestWaterStreak() {
        return longestWaterStreak;
    }

    public void setLongestWaterStreak(int longestWaterStreak) {
        this.longestWaterStreak = longestWaterStreak;
    }

}