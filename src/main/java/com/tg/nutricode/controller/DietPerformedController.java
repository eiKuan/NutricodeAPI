package com.tg.nutricode.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tg.nutricode.dto.DietPerformedRequestDto;
import com.tg.nutricode.dto.DietPerformedResponseDto;
import com.tg.nutricode.service.DietPerformedService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users/{userId}/diet-performed")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "8 - Dieta Realizada | ", description = "Registro de dietas realizadas pelo usuário")
public class DietPerformedController {

    private final DietPerformedService service;

    public DietPerformedController(DietPerformedService service) {
        this.service = service;
    }

    @Operation(
        summary = "Registrar dieta do dia",
        description = "Registra se a dieta foi seguida ou não no dia informado. "
                    + "Atualiza automaticamente a streak de dieta no perfil de progressão. "
                    + "Se isFinished = true, incrementa a streak. Se false, reseta para 0."
    )
    @PostMapping
    public ResponseEntity<DietPerformedResponseDto> save(
            @PathVariable String userId,
            @Valid @RequestBody DietPerformedRequestDto dto) {
        return ResponseEntity.ok(service.save(userId, dto));
    }

    @Operation(
        summary = "Listar todas as dietas realizadas",
        description = "Retorna todos os registros de dieta do usuário ordenados por data decrescente."
    )
    @GetMapping
    public ResponseEntity<List<DietPerformedResponseDto>> findAll(@PathVariable String userId) {
        return ResponseEntity.ok(service.findAll(userId));
    }

    @Operation(
        summary = "Última dieta registrada",
        description = "Retorna o registro de dieta mais recente do usuário."
    )
    @GetMapping("/latest")
    public ResponseEntity<DietPerformedResponseDto> findLatest(@PathVariable String userId) {
        return service.findLatest(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}