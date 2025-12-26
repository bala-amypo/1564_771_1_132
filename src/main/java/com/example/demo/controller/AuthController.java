package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import org.springframework.security.authentication.AuthenticationManager;

public class AuthController {

    private final AuthenticationManager authenticationManager;

    public AuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public void login(LoginRequest request) {
        authenticationManager.authenticate(null);
    }
}
