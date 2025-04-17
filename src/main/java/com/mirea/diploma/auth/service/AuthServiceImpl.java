package com.mirea.diploma.auth.service;

import com.mirea.diploma.auth.dto.LoginRequest;
import com.mirea.diploma.auth.dto.UserDto;
import com.mirea.diploma.auth.model.User;
import com.mirea.diploma.auth.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDto login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail());
        return new UserDto(user.getUserId(), user.getName(), user.getEmail());
    }
    @Override
    public UserDto register(UserDto userDto) {
        System.out.println("Register in logic ");
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        User saved = userRepository.save(user);
        return new UserDto(saved.getUserId(), saved.getName(), saved.getEmail());
    }
    @Override
    public void logout() {
    }
}
