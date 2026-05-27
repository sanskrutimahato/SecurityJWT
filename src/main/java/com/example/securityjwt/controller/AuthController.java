package com.example.securityjwt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.securityjwt.dto.AuthRequest;
import com.example.securityjwt.entity.User;
import com.example.securityjwt.repository.UserRepository;
import com.example.securityjwt.security.JwtUtil;
import com.example.securityjwt.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService service;
    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public AuthController(UserService service,
                          UserRepository repo,
                          PasswordEncoder encoder,
                          JwtUtil jwtUtil) {

        this.service = service;
        this.repo = repo;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {

        return service.register(user);
    }

    @PostMapping("/login")
    public Map<String, String> login(
            @RequestBody AuthRequest request) {

        User user = repo.findByUsername(
                request.getUsername()
        ).orElseThrow();

        if (encoder.matches(
                request.getPassword(),
                user.getPassword())) {

            String token =
                    jwtUtil.generateToken(user.getUsername());

            Map<String, String> response =
                    new HashMap<>();

            response.put("token", token);

            return response;
        }

        throw new RuntimeException("Invalid Credentials");
    }
}