package com.tg.nutricode.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tg.nutricode.dto.WorkoutPerformedRequestDto;
import com.tg.nutricode.dto.WorkoutPerformedResponseDto;
import com.tg.nutricode.service.WorkoutPerformedService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users/{userId}/workout-performed")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "9 - Treino Realizado | ", description = "Registro de treinos realizados pelo usuário")
public class WorkoutPerformedController {

    private final WorkoutPerformedService service;

    public WorkoutPerformedController(WorkoutPerformedService service) {
        this.service = service;
    }

    @Operation(
        summary = "Registrar treino do dia",
        description = "Registra se o treino foi realizado ou não no dia informado. "
                    + "Atualiza automaticamente a streak de treinos no perfil de progressão. "
                    + "Se isFinished = true, incrementa a streak. Se false, reseta para 0."
    )
    @PostMapping
    public ResponseEntity<WorkoutPerformedResponseDto> save(
            @PathVariable String userId,
            @Valid @RequestBody WorkoutPerformedRequestDto dto) {
        return ResponseEntity.ok(service.save(userId, dto));
    }

    @Operation(
        summary = "Listar todos os treinos realizados",
        description = "Retorna todos os registros de treino do usuário ordenados por data decrescente."
    )
    @GetMapping
    public ResponseEntity<List<WorkoutPerformedResponseDto>> findAll(@PathVariable String userId) {
        return ResponseEntity.ok(service.findAll(userId));
    }

    @Operation(
        summary = "Último treino registrado",
        description = "Retorna o registro de treino mais recente do usuário."
    )
    @GetMapping("/latest")
    public ResponseEntity<WorkoutPerformedResponseDto> findLatest(@PathVariable String userId) {
        return service.findLatest(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}