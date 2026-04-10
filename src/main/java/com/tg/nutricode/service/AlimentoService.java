package com.tg.nutricode.service;

import com.tg.nutricode.model.Alimento;
import com.tg.nutricode.repository.AlimentoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlimentoService {

    private final AlimentoRepository alimentoRepository;

    public AlimentoService(AlimentoRepository alimentoRepository) {
        this.alimentoRepository = alimentoRepository;
    }

    public List<Alimento> listarTodos() {
        return alimentoRepository.findAll();
    }

    public Optional<Alimento> buscarPorId(Integer id) {
        return alimentoRepository.findById(id);
    }

    public List<Alimento> buscarPorNome(String nome) {
        return alimentoRepository.findByNameContainingIgnoreCase(nome);
    }
}