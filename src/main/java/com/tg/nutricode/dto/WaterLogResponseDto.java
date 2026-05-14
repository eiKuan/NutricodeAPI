package com.tg.nutricode.dto;

import java.time.LocalDate;

public record WaterLogResponseDto(
    Integer milliliters,
    LocalDate date,
    boolean isCompleted,
    long xpEarned
) {

}