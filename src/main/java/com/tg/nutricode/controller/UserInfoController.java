package com.tg.nutricode.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tg.nutricode.dto.UserInfoRequestDto;
import com.tg.nutricode.dto.UserInfoResponseDto;
import com.tg.nutricode.service.UserInfoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users/{userId}/info")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "2 - User Info | ", description = "Informações físicas do usuário")
public class UserInfoController {

    private final UserInfoService service;

    public UserInfoController(UserInfoService service) {
        this.service = service;
    }

    @Operation(
        summary = "Buscar informações físicas",
        description = "Retorna altura, data de nascimento e sexo do usuário."
    )
    @GetMapping
    public ResponseEntity<UserInfoResponseDto> findByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(service.findByUserId(userId));
    }

    @Operation(
        summary = "Inserir ou atualizar informações físicas",
        description = "Cria ou atualiza as informações físicas do usuário. "
                    + "Todos os campos são opcionais — envie apenas o que deseja atualizar. "
                    + "Altura em centímetros (ex: 175)."
    )
    @PutMapping
    public ResponseEntity<UserInfoResponseDto> save(
            @PathVariable String userId,
            @Valid @RequestBody UserInfoRequestDto dto) {
        return ResponseEntity.ok(service.save(userId, dto));
    }
}