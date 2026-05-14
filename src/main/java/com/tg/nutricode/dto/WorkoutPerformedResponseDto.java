package com.tg.nutricode.dto;

import java.time.LocalDate;

public record WorkoutPerformedResponseDto(
    LocalDate date,
    boolean isFinished,
    long xpEarned  // XP ganho nessa ação (0 se isFinished = false)
) {

}