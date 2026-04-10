package com.tg.nutricode.dto;

import java.util.List;

// Record = classe imutável usada para transportar dados
public record ExercicioResponseDto(

        String id,
        String name,
        String force,
        String level,
        String mechanic,
        String equipment,

        // Listas vindas do banco
        List<String> primaryMuscles,
        List<String> secondaryMuscles,
        List<String> instructions,

        String category,

        // URLs completas das imagens
        List<String> images
) {
        
}