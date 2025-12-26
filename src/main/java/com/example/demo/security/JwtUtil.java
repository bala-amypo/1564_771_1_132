// package com.example.demo.security;

// import java.util.Base64;

// public class JwtUtil {

//     public String generateToken(String email, String role, Long userId) {
//         return Base64.getEncoder()
//                 .encodeToString((email + "|" + role + "|" + userId).getBytes());
//     }

//     public boolean validateToken(String token) {
//         try {
//             Base64.getDecoder().decode(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }

//     public String extractEmail(String token) {
//         return new String(Base64.getDecoder().decode(token)).split("\\|")[0];
//     }

//     public String extractRole(String token) {
//         return new String(Base64.getDecoder().decode(token)).split("\\|")[1];
//     }

//     public Long extractUserId(String token) {
//         return Long.parseLong(new String(Base64.getDecoder().decode(token)).split("\\|")[2]);
//     }
// }

package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long EXPIRATION = 1000 * 60 * 60; // 1 hour

    public String generateToken(String email, String role, Long userId) {
        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .claim("userId", userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(key)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public String extractEmail(String token) {
        return extractClaims(token).getSubject();
    }

    public String extractRole(String token) {
        return extractClaims(token).get("role", String.class);
    }

    public Long extractUserId(String token) {
        return extractClaims(token).get("userId", Long.class);
    }

    private Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}

