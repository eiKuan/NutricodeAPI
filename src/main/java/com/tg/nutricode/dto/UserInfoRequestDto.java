package com.tg.nutricode.dto;

import java.time.LocalDate;
import com.tg.nutricode.model.Sex;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public record UserInfoRequestDto(

    @NotNull(message = "Altura é obrigatória")
    @Min(value = 50, message = "Altura mínima é 50cm")
    @Max(value = 250, message = "Altura máxima é 250cm")
    Integer height,

    @NotNull(message = "Data de nascimento é obrigatória")
    @Past(message = "Data de nascimento deve ser no passado")
    LocalDate birthDate,

    @NotNull(message = "Sexo é obrigatório")
    Sex sex

) {
    
}