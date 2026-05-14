package com.tg.nutricode.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;

public record WeightLogRequestDto(
    @NotNull(message = "Peso é obrigatório")
    @Positive(message = "Peso deve ser positivo")
    Double weight,

    @NotNull(message = "Data é obrigatória")
    LocalDate date
) {

}