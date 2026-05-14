package com.tg.nutricode.dto;

import com.tg.nutricode.model.Sex;

public record UserInfoResponseDto(
    Integer height,
    Integer age,
    Sex sex
) {
    
}