package com.tg.nutricode.dto;

public record RegisterResponseDto(
    String username,
    String email,
    String confirmationToken
) {}