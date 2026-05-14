package com.tg.nutricode.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tg.nutricode.dto.WeightLogRequestDto;
import com.tg.nutricode.dto.WeightLogResponseDto;
import com.tg.nutricode.model.User;
import com.tg.nutricode.model.WeightLog;
import com.tg.nutricode.repository.UserRepository;
import com.tg.nutricode.repository.WeightLogRepository;

@Service
public class WeightLogService {

    private final WeightLogRepository weightLogRepository;
    private final UserRepository userRepository;

    public WeightLogService(WeightLogRepository weightLogRepository,
                            UserRepository userRepository) {
        this.weightLogRepository = weightLogRepository;
        this.userRepository = userRepository;
    }

    // upsert — cria ou atualiza o registro do dia
    @Transactional
    public WeightLogResponseDto save(String userId, WeightLogRequestDto dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // verifica se já existe registro para o dia
        WeightLog weightLog = weightLogRepository
                .findByUser_UserIdAndDate(userId, dto.date())
                .orElse(new WeightLog(user, dto.date(), dto.weight()));

        // atualiza o peso se já existir
        weightLog.setWeight(dto.weight());
        weightLogRepository.save(weightLog);

        return toDto(weightLog);
    }

    public List<WeightLogResponseDto> findAll(String userId) {
        return weightLogRepository.findByUser_UserIdOrderByDateDesc(userId)
                .stream()
                .map(this::toDto)
                .toList();
    }

    public Optional<WeightLogResponseDto> findLatest(String userId) {
        return weightLogRepository.findFirstByUser_UserIdOrderByDateDesc(userId)
                .map(this::toDto);
    }

    public List<WeightLogResponseDto> findLastMonth(String userId) {
        LocalDate startDate = LocalDate.now().minusDays(30);
        return weightLogRepository.findLastMonthByUserId(userId, startDate)
                .stream()
                .map(this::toDto)
                .toList();
    }

    private WeightLogResponseDto toDto(WeightLog log) {
        return new WeightLogResponseDto(log.getWeight(), log.getDate());
    }
}