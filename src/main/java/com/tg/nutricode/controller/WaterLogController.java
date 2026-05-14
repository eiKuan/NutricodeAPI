package com.tg.nutricode.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tg.nutricode.dto.WaterLogRequestDto;
import com.tg.nutricode.dto.WaterLogResponseDto;
import com.tg.nutricode.service.WaterLogService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users/{userId}/water-logs")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "6 - Registro de água | ", description = "Logs de consumo de água do usuário")
public class WaterLogController {

    private final WaterLogService service;

    public WaterLogController(WaterLogService service) {
        this.service = service;
    }

    @Operation(summary = "Inserir ou atualizar consumo de água do dia",
               description = "Cria um novo registro de água ou atualiza se já existir um para a data informada.")
    @PostMapping
    public ResponseEntity<WaterLogResponseDto> save(
            @PathVariable String userId,
            @Valid @RequestBody WaterLogRequestDto dto) {
        return ResponseEntity.ok(service.save(userId, dto));
    }

    @Operation(summary = "Listar todos os registros de água",
               description = "Retorna todos os registros de água do usuário ordenados por data decrescente.")
    @GetMapping
    public ResponseEntity<List<WaterLogResponseDto>> findAll(@PathVariable String userId) {
        return ResponseEntity.ok(service.findAll(userId));
    }

    @Operation(summary = "Último registro de água",
               description = "Retorna o registro de água mais recente do usuário.")
    @GetMapping("/latest")
    public ResponseEntity<WaterLogResponseDto> findLatest(@PathVariable String userId) {
        return service.findLatest(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Registros do último mês",
               description = "Retorna os registros de água dos últimos 30 dias.")
    @GetMapping("/last-month")
    public ResponseEntity<List<WaterLogResponseDto>> findLastMonth(@PathVariable String userId) {
        return ResponseEntity.ok(service.findLastMonth(userId));
    }
}