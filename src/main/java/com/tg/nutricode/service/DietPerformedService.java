package com.tg.nutricode.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tg.nutricode.dto.DietPerformedRequestDto;
import com.tg.nutricode.dto.DietPerformedResponseDto;
import com.tg.nutricode.model.DietPerformed;
import com.tg.nutricode.model.User;
import com.tg.nutricode.model.UserProgressionProfile;
import com.tg.nutricode.repository.DietPerformedRepository;
import com.tg.nutricode.repository.UserProgressionProfileRepository;
import com.tg.nutricode.repository.UserRepository;

@Service
public class DietPerformedService {

    private final DietPerformedRepository dietPerformedRepository;
    private final UserRepository userRepository;
    private final UserProgressionProfileRepository progressionRepository;
    private final ProgressionCalculator progressionCalculator;

    public DietPerformedService(DietPerformedRepository dietPerformedRepository,
                                UserRepository userRepository,
                                UserProgressionProfileRepository progressionRepository,
                                ProgressionCalculator progressionCalculator) {
        this.dietPerformedRepository = dietPerformedRepository;
        this.userRepository = userRepository;
        this.progressionRepository = progressionRepository;
        this.progressionCalculator = progressionCalculator;
    }

    @Transactional
    public DietPerformedResponseDto save(String userId, DietPerformedRequestDto dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        DietPerformed diet = dietPerformedRepository
                .findByUser_UserIdAndDate(userId, dto.date())
                .orElse(new DietPerformed(user, dto.date(), dto.isFinished()));

        diet.setFinished(dto.isFinished());
        dietPerformedRepository.save(diet);

        UserProgressionProfile profile = progressionRepository.findByUser_UserId(userId)
                .orElseThrow(() -> new RuntimeException("Progression profile not found"));

        long xpEarned = progressionCalculator.updateDietStreakAndApplyXp(profile, dto.isFinished());

        return toDto(diet, xpEarned);
    }

    public List<DietPerformedResponseDto> findAll(String userId) {
        return dietPerformedRepository.findByUser_UserIdOrderByDateDesc(userId)
                .stream()
                .map(d -> toDto(d, 0))
                .toList();
    }

    public Optional<DietPerformedResponseDto> findLatest(String userId) {
        return dietPerformedRepository.findFirstByUser_UserIdOrderByDateDesc(userId)
                .map(d -> toDto(d, 0));
    }

    private DietPerformedResponseDto toDto(DietPerformed diet, long xpEarned) {
        return new DietPerformedResponseDto(diet.getDate(), diet.isFinished(), xpEarned);
    }
}