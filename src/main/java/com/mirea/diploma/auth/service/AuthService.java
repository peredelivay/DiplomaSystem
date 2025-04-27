package com.mirea.diploma.auth.service;

import com.mirea.diploma.auth.dto.*;

public interface AuthService {
    UserDto register(RegisterRequest dto);
    UserDto login(LoginRequest dto);
}
