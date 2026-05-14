package com.tg.nutricode.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tg.nutricode.dto.ExercicioResponseDto;
import com.tg.nutricode.service.ExercicioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/exercicios")
@SecurityRequirement(name = "bearerAuth")
@Tag(
    name = "5 - Exercícios | ", 
    description = "Controlador que somente retorna dados dos exercícios cadastrados. Fonte: joao-gugel, Exercicios-Bd-PtBr. Paginaçao padrao para retorno mais rapido."
)
public class ExercicioController {

    private final ExercicioService service;

    public ExercicioController(ExercicioService service) {
        this.service = service;
    }

    @Operation(
        summary = "Busca e retorna todos os exercicios" ,
        description = "Retorna todos os (quase) 900 exercícios cadastrados, Por padrao paginado por 20 resultados por vez, mt pesado. 44 a 45 paginas no total"
    )
    @GetMapping
    public Page<ExercicioResponseDto> findAll(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "20") int size) {
        return service.findAll(page, size);
    }

    @Operation(
        summary = "Buscar por Id" ,
        description = "Busca o exercício por Id. Lembrando que os IDs de Exercicios são Strings"
    )
    @GetMapping("/{id}")
    public ExercicioResponseDto findById(@PathVariable String id) {
        return service.findById(id);
    }

    @Operation(
        summary = "Buscar por Nome" ,
        description = "Busca e retorna todos os exercícios (Lista) que contém o conteúdo pesquisado no nome. " 
                    + "Exemplo: ao buscar \"Rosca\", exercícios com nomes de \"Rosca Martelo\", \"Rosca Alternada\" etc. Serão retornados."
    )
    @GetMapping("/buscar/nome")
    public Page<ExercicioResponseDto> findByName(
        @RequestParam String name,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "20") int size) {
        return service.findByName(name, page, size);
    }

    // GETs especificos, caso os cabrinhas queiram adicionar outros tipos de pesquisa

    @Operation(
        summary = "Buscar por Equipamento" ,
        description = "Busca e retorna todos os exercícios pelo equipamento informado. " 
                    + "Sendo eles: peso-do-corpo, maquina, outros, rolo-de-espuma, kettlebell"
                    + "halteres, cabo, barra, faixas, bola-medicinal, bola-de-exercicio, null."
    )
    @GetMapping("/buscar/equipamento")
    public Page<ExercicioResponseDto> findByEquipment(
        @RequestParam String equipment,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "20") int size) {
        return service.findByEquipment(equipment, page, size);
    }


    @Operation(
        summary = "Busca e retorna todos os exercícios pelo nível de dificuldade. " ,
        description = "Busca o exercicio pelo nivel de dificuldade. " 
                    + "Sendo eles: Iniciante, Intermediario e Avancado"
    )
    @GetMapping("/buscar/nivel")
    public Page<ExercicioResponseDto> findByLevel(
        @RequestParam String level,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "20") int size) {
        return service.findByLevel(level, page, size);
    }


    @Operation(
        summary = "Busca o exercicio por sua categoria de execução." ,
        description = "Busca e retorna todos os exercícios por sua categoria. "
                    + "Sendo elas: forca, alongamento, pliometria, strongman, powerlifting"
    )
    @GetMapping("/buscar/categoria")
    public Page<ExercicioResponseDto> findByCategory(
        @RequestParam String category,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "20") int size) {
        return service.findByCategory(category, page, size);
    }

    @Operation(
    summary = "Buscar por Músculo Principal",
    description = "Busca e retorna todos os exercícios pelo músculo principal informado. "
                + "Exemplos: peito, costas, biceps, triceps, ombros, pernas, abdomen"
    )
    @GetMapping("/buscar/musculoprincipal")
    public Page<ExercicioResponseDto> findByPrimaryMuscle(
        @RequestParam String muscle,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "20") int size) {
        return service.findByPrimaryMuscle(muscle, page, size);
    }
    /* QUANDO FOR PRA COLOCAR PRA PESQUISAR POR MUSCULO PRIMARIO:
    CASO FOR COLOCAR PRA TIPO DE FORCE TBM
    Force: push, pull, static, null.
    */
}