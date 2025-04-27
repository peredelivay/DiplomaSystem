package com.mirea.diploma.auth.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.mirea.diploma.auth.dto.*;
import com.mirea.diploma.auth.model.*;
import com.mirea.diploma.auth.repository.*;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder encoder;

    @Override
    public UserDto register(RegisterRequest dto) {
        Role r = roleRepo.findByName(dto.getRole());
        User sup = dto.getSupervisorId() != null
                ? userRepo.findById(dto.getSupervisorId()).orElse(null)
                : null;

        User u = User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(encoder.encode(dto.getPassword()))
                .groupName(dto.getGroupName())
                .role(r)
                .supervisor(sup)
                .build();

        userRepo.save(u);
        return toDto(u);
    }

    @Override
    public UserDto login(LoginRequest dto) {
        User u = userRepo.findByEmail(dto.getEmail());
        if (u == null || !encoder.matches(dto.getPassword(), u.getPassword())) {
            throw new RuntimeException("Ошибка авторизации");
        }
        return toDto(u);
    }

    private UserDto toDto(User u) {
        return UserDto.builder()
                .id(u.getId())
                .name(u.getName())
                .email(u.getEmail())
                .groupName(u.getGroupName())
                .role(u.getRole().getName())
                .supervisorId(u.getSupervisor() != null ? u.getSupervisor().getId() : null)
                .build();
    }
}
