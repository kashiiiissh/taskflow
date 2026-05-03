package com.kashish.taskflow.controller;

import com.kashish.taskflow.dto.AuthResponse;
import com.kashish.taskflow.dto.AuthRequest;
import com.kashish.taskflow.entity.User;
import com.kashish.taskflow.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody User user) {
        String token = authService.register(user);
        return new AuthResponse(token);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        String token = authService.login(request.getEmail(), request.getPassword());
        return new AuthResponse(token);
    }
}