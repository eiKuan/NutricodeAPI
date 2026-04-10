package com.tg.nutricode.controller;

import com.tg.nutricode.model.Alimento;
import com.tg.nutricode.service.AlimentoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/alimentos")
@SecurityRequirement(name = "bearerAuth")
@Tag(
    name = "Alimentos | ", 
    description = "Controlador que somente retorna dados dos alimentos cadastrados. "
                + "Fonte: TACO ( Tabela Brasileira de Composição de Alimentos)" 
)
public class AlimentoController {

    private final AlimentoService alimentoService;

    public AlimentoController(AlimentoService alimentoService) {
        this.alimentoService = alimentoService;
    }

    @Operation(
        summary = "Busca e retorna todos os alimentos" ,
        description = "Retorna todos os (quase) 600 alimentos cadastrados"
    )
    @GetMapping
    public List<Alimento> listarTodos() {
        return alimentoService.listarTodos();
    }

    @Operation(
        summary = "Buscar por Id" ,
        description = "Busca o alimento por Id. Lembrando que os IDs de Alimentos são números"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Alimento> buscarPorId(@PathVariable Integer id) {
        return alimentoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
        summary = "Buscar por Nome" ,
        description = "Busca e retorna todos os alimentos (Lista) que contém o conteúdo pesquisado no nome. " 
                    + "Exemplo: ao buscar \"Arroz\", alimentos com nomes de \"Arroz cozido\", \"Arroz cru\" etc. Serão retornados."
    )
    @GetMapping("/buscar")
    public List<Alimento> buscarPorNome(@RequestParam String nome) {
        return alimentoService.buscarPorNome(nome);
    }
}