package com.tg.nutricode.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record DietPerformedRequestDto(
    @NotNull(message = "Data é obrigatória")
    LocalDate date,

    @NotNull(message = "Status é obrigatório")
    Boolean isFinished
) {
    
}