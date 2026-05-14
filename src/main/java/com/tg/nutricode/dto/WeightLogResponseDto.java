package com.tg.nutricode.dto;

import java.time.LocalDate;

public record WeightLogResponseDto(
    Double weight,
    LocalDate date
) {
    
}