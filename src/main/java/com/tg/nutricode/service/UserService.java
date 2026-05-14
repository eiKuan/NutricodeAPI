package com.tg.nutricode.service;

import java.util.List;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.tg.nutricode.dto.UpdateUserDto;
import com.tg.nutricode.dto.UserResponseDto;
import com.tg.nutricode.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<UserResponseDto> getUserById(String userId) {
        return userRepository.findById(userId)
                .map(user -> new UserResponseDto(
                    user.getUserId(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getCreationTimestamp(),
                    user.getUpdateTimestamp()
                ));
    }

    public List<UserResponseDto> listUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponseDto(
                    user.getUserId(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getCreationTimestamp(),
                    user.getUpdateTimestamp()
                ))
                .toList();
    }

    public void deleteById(String userId) {

        var userExists = userRepository.existsById(userId);
        if (userExists) {
            userRepository.deleteById(userId);
        }
    }

    public void updateUserById(String userId, UpdateUserDto updateUserDto) {

        var userEntity = userRepository.findById(userId);
        if (userEntity.isPresent()) {
            var user = userEntity.get();
            if (updateUserDto.username() != null) {
                user.setUsername(updateUserDto.username());
            }
            if (updateUserDto.password() != null) {
                // senha precisa ser encodada antes de salvar

                user.setPassword(passwordEncoder.encode(updateUserDto.password()));
            }
            userRepository.save(user);
        }
    }

    public UserResponseDto getAuthenticatedUser() {
        String email = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();
        
        System.out.println("Email do token: " + email); // log temporário
        
        return userRepository.findByEmail(email)
                .map(user -> new UserResponseDto(
                    user.getUserId(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getCreationTimestamp(),
                    user.getUpdateTimestamp()
                ))
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}