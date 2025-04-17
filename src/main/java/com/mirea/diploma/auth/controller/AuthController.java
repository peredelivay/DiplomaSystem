package com.mirea.diploma.auth.controller;

import com.mirea.diploma.auth.dto.LoginRequest;
import com.mirea.diploma.auth.dto.UserDto;
import com.mirea.diploma.auth.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService) {
        System.out.println("AUTH CONTROLLER");
        this.authService = authService;
    }
    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginRequest request) {
        System.out.println(request.getEmail() + " " + request.getPassword());
        return ResponseEntity.ok(authService.login(request));
    }
    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto) {
        System.out.println("REGISTER NEW USER");
        return ResponseEntity.ok(authService.register(userDto));
    }
    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {
        authService.logout();
        return ResponseEntity.ok().build();
    }
}
