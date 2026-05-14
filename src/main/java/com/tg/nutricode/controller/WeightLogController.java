package com.tg.nutricode.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tg.nutricode.dto.WeightLogRequestDto;
import com.tg.nutricode.dto.WeightLogResponseDto;
import com.tg.nutricode.service.WeightLogService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users/{userId}/weight-logs")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "7 - Registro de peso | ", description = "Logs de peso do usuário")
public class WeightLogController {

    private final WeightLogService service;

    public WeightLogController(WeightLogService service) {
        this.service = service;
    }

    @Operation(summary = "Inserir ou atualizar peso do dia",
               description = "Cria um novo registro de peso ou atualiza se já existir um para a data informada.")
    @PostMapping
    public ResponseEntity<WeightLogResponseDto> save(
            @PathVariable String userId,
            @Valid @RequestBody WeightLogRequestDto dto) {
        return ResponseEntity.ok(service.save(userId, dto));
    }

    @Operation(summary = "Listar todos os registros de peso",
               description = "Retorna todos os registros de peso do usuário ordenados por data decrescente.")
    @GetMapping
    public ResponseEntity<List<WeightLogResponseDto>> findAll(@PathVariable String userId) {
        return ResponseEntity.ok(service.findAll(userId));
    }

    @Operation(summary = "Último registro de peso",
               description = "Retorna o registro de peso mais recente do usuário.")
    @GetMapping("/latest")
    public ResponseEntity<WeightLogResponseDto> findLatest(@PathVariable String userId) {
        return service.findLatest(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Registros do último mês",
               description = "Retorna os registros de peso dos últimos 30 dias.")
    @GetMapping("/last-month")
    public ResponseEntity<List<WeightLogResponseDto>> findLastMonth(@PathVariable String userId) {
        return ResponseEntity.ok(service.findLastMonth(userId));
    }
}