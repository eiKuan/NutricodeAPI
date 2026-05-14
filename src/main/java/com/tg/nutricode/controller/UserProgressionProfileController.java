package com.tg.nutricode.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tg.nutricode.dto.UserProgressionProfileResponseDto;
import com.tg.nutricode.service.UserProgressionProfileService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/users/{userId}/progression")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "3 - Status do Usuário | ", description = "Perfil de progressão, XP, level e streaks do usuário.")
public class UserProgressionProfileController {

    private final UserProgressionProfileService service;

    public UserProgressionProfileController(UserProgressionProfileService service) {
        this.service = service;
    }

    @Operation(
        summary = "Buscar perfil de progressão",
        description = "Retorna XP atual, level, XP necessário para o próximo level, "
                    + "recompensa atual de XP e todas as streaks do usuário."
    )
    @GetMapping
    public ResponseEntity<UserProgressionProfileResponseDto> findByUserId(
            @PathVariable String userId) {
        return ResponseEntity.ok(service.findByUserId(userId));
    }
}