package com.tg.nutricode.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tg.nutricode.dto.UserInfoRequestDto;
import com.tg.nutricode.dto.UserInfoResponseDto;
import com.tg.nutricode.model.User;
import com.tg.nutricode.model.UserInfo;
import com.tg.nutricode.repository.UserInfoRepository;
import com.tg.nutricode.repository.UserRepository;

@Service
public class UserInfoService {

    private final UserInfoRepository userInfoRepository;
    private final UserRepository userRepository;

    public UserInfoService(UserInfoRepository userInfoRepository,
                           UserRepository userRepository) {
        this.userInfoRepository = userInfoRepository;
        this.userRepository = userRepository;
    }

    public UserInfoResponseDto findByUserId(String userId) {
        return userInfoRepository.findByUser_UserId(userId)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("User info not found"));
    }

    @Transactional
    public UserInfoResponseDto save(String userId, UserInfoRequestDto dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserInfo userInfo = userInfoRepository.findByUser_UserId(userId)
                .orElse(new UserInfo(user));

        if (dto.height() != null) userInfo.setHeight(dto.height());
        if (dto.birthDate() != null) userInfo.setBirthDate(dto.birthDate());
        if (dto.sex() != null) userInfo.setSex(dto.sex());

        userInfoRepository.save(userInfo);
        return toDto(userInfo);
    }

    private UserInfoResponseDto toDto(UserInfo userInfo) {
        Integer age = null;
        if (userInfo.getBirthDate() != null) {
            age = java.time.Period.between(userInfo.getBirthDate(), java.time.LocalDate.now()).getYears();
        }

        return new UserInfoResponseDto(
            userInfo.getHeight(),
            age,
            userInfo.getSex()
        );
    }
}