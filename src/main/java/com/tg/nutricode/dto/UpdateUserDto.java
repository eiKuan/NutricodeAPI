package com.tg.nutricode.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UpdateUserDto(

    @Size(min = 3, max = 20, message = "Username deve ter entre 3 e 20 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username só pode conter letras, números e _")
    String username,

    @Size(min = 8, max = 100, message = "Senha deve ter no mínimo 8 caracteres")
    @Pattern(
        regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",
        message = "Senha deve conter pelo menos uma letra maiúscula, uma minúscula e um número"
    )
    String password

) {

    
}