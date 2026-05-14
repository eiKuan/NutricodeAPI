package com.tg.nutricode.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tg.nutricode.dto.WorkoutPerformedRequestDto;
import com.tg.nutricode.dto.WorkoutPerformedResponseDto;
import com.tg.nutricode.model.User;
import com.tg.nutricode.model.UserProgressionProfile;
import com.tg.nutricode.model.WorkoutPerformed;
import com.tg.nutricode.repository.UserProgressionProfileRepository;
import com.tg.nutricode.repository.UserRepository;
import com.tg.nutricode.repository.WorkoutPerformedRepository;

@Service
public class WorkoutPerformedService {

    private final WorkoutPerformedRepository workoutPerformedRepository;
    private final UserRepository userRepository;
    private final UserProgressionProfileRepository progressionRepository;
    private final ProgressionCalculator progressionCalculator;

    public WorkoutPerformedService(WorkoutPerformedRepository workoutPerformedRepository,
                                   UserRepository userRepository,
                                   UserProgressionProfileRepository progressionRepository,
                                   ProgressionCalculator progressionCalculator) {
        this.workoutPerformedRepository = workoutPerformedRepository;
        this.userRepository = userRepository;
        this.progressionRepository = progressionRepository;
        this.progressionCalculator = progressionCalculator;
    }

    @Transactional
    public WorkoutPerformedResponseDto save(String userId, WorkoutPerformedRequestDto dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        WorkoutPerformed workout = workoutPerformedRepository
                .findByUser_UserIdAndDate(userId, dto.date())
                .orElse(new WorkoutPerformed(user, dto.date(), dto.isFinished()));

        workout.setFinished(dto.isFinished());
        workoutPerformedRepository.save(workout);

        UserProgressionProfile profile = progressionRepository.findByUser_UserId(userId)
                .orElseThrow(() -> new RuntimeException("Progression profile not found"));

        long xpEarned = progressionCalculator.updateWorkoutStreakAndApplyXp(profile, dto.isFinished());

        return toDto(workout, xpEarned);
    }

    public List<WorkoutPerformedResponseDto> findAll(String userId) {
        return workoutPerformedRepository.findByUser_UserIdOrderByDateDesc(userId)
                .stream()
                .map(w -> toDto(w, 0))
                .toList();
    }

    public Optional<WorkoutPerformedResponseDto> findLatest(String userId) {
        return workoutPerformedRepository.findFirstByUser_UserIdOrderByDateDesc(userId)
                .map(w -> toDto(w, 0));
    }

    private WorkoutPerformedResponseDto toDto(WorkoutPerformed workout, long xpEarned) {
        return new WorkoutPerformedResponseDto(workout.getDate(), workout.isFinished(), xpEarned);
    }
}