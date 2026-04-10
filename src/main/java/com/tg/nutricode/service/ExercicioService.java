package com.tg.nutricode.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tg.nutricode.dto.ExercicioResponseDto;
import com.tg.nutricode.model.Exercicio;
import com.tg.nutricode.repository.ExercicioRepository;

@Service
public class ExercicioService {

    private final ExercicioRepository repository;

    // Para n precisar salvar imagens na nossa Api Free.
    private final String BASE_URL =
        "https://raw.githubusercontent.com/yuhonas/free-exercise-db/main/exercises/";

    public ExercicioService(ExercicioRepository repository) {
        this.repository = repository;
    }

    private ExercicioResponseDto toDto(Exercicio exercicio) {
        List<String> images = exercicio.getImages() == null
            ? List.of()
            : exercicio.getImages()
                .stream()
                .map(img -> BASE_URL + img)
                .toList();

        return new ExercicioResponseDto(
                exercicio.getId(),
                exercicio.getName(),
                exercicio.getForce(),
                exercicio.getLevel(),
                exercicio.getMechanic(),
                exercicio.getEquipment(),
                exercicio.getPrimaryMuscles(),
                exercicio.getSecondaryMuscles(),
                exercicio.getInstructions(),
                exercicio.getCategory(),
                images
        );
    }

    public Page<ExercicioResponseDto> findAll(int page, int size) {
        return repository.findAll(PageRequest.of(page, size))
                .map(this::toDto);
    }

    public Page<ExercicioResponseDto> findByName(String name, int page, int size) {
        return repository.findByNameContainingIgnoreCase(name, PageRequest.of(page, size))
                .map(this::toDto);
    }

    public Page<ExercicioResponseDto> findByEquipment(String equipment, int page, int size) {
        return repository.findByEquipmentContainingIgnoreCase(equipment, PageRequest.of(page, size))
                .map(this::toDto);
    }

    public Page<ExercicioResponseDto> findByLevel(String level, int page, int size) {
        return repository.findByLevelContainingIgnoreCase(level, PageRequest.of(page, size))
                .map(this::toDto);
    }

    public Page<ExercicioResponseDto> findByCategory(String category, int page, int size) {
        return repository.findByCategoryContainingIgnoreCase(category, PageRequest.of(page, size))
                .map(this::toDto);
    }

    public Page<ExercicioResponseDto> findByPrimaryMuscle(String muscle, int page, int size) {
        return repository.findByPrimaryMusclesContainingIgnoreCase(muscle, PageRequest.of(page, size))
                .map(this::toDto);
    }

    public ExercicioResponseDto findById(String id) {
        return repository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Exercício não encontrado"));
    }

    @Transactional
    public void saveAll(List<Exercicio> exercicios) {
        repository.saveAll(exercicios);
    }

    public long count() {
        return repository.count();
    }
}