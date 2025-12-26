package com.example.demo.security;

import java.util.Base64;

public class JwtUtil {

    public String generateToken(String email, String role, Long userId) {
        return Base64.getEncoder()
                .encodeToString((email + "|" + role + "|" + userId).getBytes());
    }

    public boolean validateToken(String token) {
        try {
            Base64.getDecoder().decode(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String extractEmail(String token) {
        return new String(Base64.getDecoder().decode(token)).split("\\|")[0];
    }

    public String extractRole(String token) {
        return new String(Base64.getDecoder().decode(token)).split("\\|")[1];
    }

    public Long extractUserId(String token) {
        return Long.parseLong(new String(Base64.getDecoder().decode(token)).split("\\|")[2]);
    }
}
