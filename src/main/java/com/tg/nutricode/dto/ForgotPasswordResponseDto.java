package com.tg.nutricode.dto;

public record ForgotPasswordResponseDto(
    String username,
    String email,
    String resetToken
) {

    
}