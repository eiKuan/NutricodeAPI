package com.tg.nutricode.dto;

public record ResponseDto(
    String username,
    String token,           // access token
    String refreshToken     // refresh token (só quando "manter login")
) {
    
}
