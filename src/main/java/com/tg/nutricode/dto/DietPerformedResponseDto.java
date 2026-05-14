package com.tg.nutricode.dto;

import java.time.LocalDate;

public record DietPerformedResponseDto(
    LocalDate date,
    boolean isFinished,
    long xpEarned
) {

}