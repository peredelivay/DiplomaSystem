package com.mirea.diploma.auth.service;

import com.mirea.diploma.auth.dto.LoginRequest;
import com.mirea.diploma.auth.dto.UserDto;

public interface AuthService {
    UserDto login(LoginRequest request);
    UserDto register(UserDto userDto);
    void logout();
}
