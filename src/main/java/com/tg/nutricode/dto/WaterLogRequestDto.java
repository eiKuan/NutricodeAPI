package com.tg.nutricode.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;

public record WaterLogRequestDto(
    @NotNull(message = "Quantidade é obrigatória")
    @Positive(message = "Quantidade deve ser positiva")
    Integer milliliters,

    @NotNull(message = "Data é obrigatória")
    LocalDate date,

    @NotNull(message = "Status é obrigatório")
    Boolean isCompleted
) {

}