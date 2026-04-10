package com.tg.nutricode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tg.nutricode.model.Alimento;

@Repository
public interface AlimentoRepository extends JpaRepository<Alimento, Integer>{

    //Retorna varios alimentos, ContainingIgnoreCase?
    List<Alimento> findByNameContainingIgnoreCase(String name);
}