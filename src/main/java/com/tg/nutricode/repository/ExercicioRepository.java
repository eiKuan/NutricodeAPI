package com.tg.nutricode.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tg.nutricode.model.Exercicio;

@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, String> {

    Page<Exercicio> findByNameContainingIgnoreCase(String name, Pageable pageable);

    Page<Exercicio> findByEquipmentContainingIgnoreCase(String equipment, Pageable pageable);

    Page<Exercicio> findByLevelContainingIgnoreCase(String level, Pageable pageable);

    Page<Exercicio> findByCategoryContainingIgnoreCase(String category, Pageable pageable);

    Page<Exercicio> findByPrimaryMusclesContainingIgnoreCase(String muscle, Pageable pageable);

    Optional<Exercicio> findById(String id);
}