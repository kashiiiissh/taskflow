package com.kashish.taskflow.service;

import com.kashish.taskflow.entity.User;
import com.kashish.taskflow.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JwtTokenProvider jwtProvider;

    public String register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return jwtProvider.generateToken(user.getEmail());
    }

    public String login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow();

        if (!encoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtProvider.generateToken(email);
    }
}