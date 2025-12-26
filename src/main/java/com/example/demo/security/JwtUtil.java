


// package com.example.demo.security;

// import io.jsonwebtoken.*;
// import java.util.Date;

// public class JwtUtil {

//     private final String SECRET = "skillbartersecretkey";

//     public String generateToken(String email, String role, Long userId) {
//         return Jwts.builder()
//                 .setSubject(email)
//                 .claim("role", role)
//                 .claim("userId", userId)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + 86400000))
//                 .signWith(SignatureAlgorithm.HS256, SECRET)
//                 .compact();
//     }

//     public boolean validateToken(String token) {
//         try {
//             Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }

//     public String extractEmail(String token) {
//         return getClaims(token).getSubject();
//     }

//     public String extractRole(String token) {
//         return getClaims(token).get("role", String.class);
//     }

//     public Long extractUserId(String token) {
//         return getClaims(token).get("userId", Long.class);
//     }

//     private Claims getClaims(String token) {
//         return Jwts.parser()
//                 .setSigningKey(SECRET)
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// }

// package com.example.demo.security;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import org.springframework.stereotype.Component;

// import java.util.Date;

// @Component
// public class JwtUtil {

//     private final String SECRET_KEY = "secret";
//     private final long EXPIRATION_MS = 86400000; 

//     public String generateToken(String email, String role, Long userId) {
//         return Jwts.builder()
//                 .setSubject(email)
//                 .claim("role", role)
//                 .claim("userId", userId)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
//                 .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                 .compact();
//     }

//     public boolean validateToken(String token) {
//         try {
//             Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }

//     public String extractEmail(String token) {
//         return getClaims(token).getSubject();
//     }

//     public String extractRole(String token) {
//         return (String) getClaims(token).get("role");
//     }

//     public Long extractUserId(String token) {
//         return ((Number) getClaims(token).get("userId")).longValue();
//     }

//     private Claims getClaims(String token) {
//         return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
//     }
// }

package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    // ✅ Secure 256-bit key for HS256
    private final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    private final long EXPIRATION_MS = 86400000; // 1 day

    public String generateToken(String email, String role, Long userId) {
        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .claim("userId", userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
                .signWith(SECRET_KEY)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String extractEmail(String token) {
        return getClaims(token).getSubject();
    }

    public String extractRole(String token) {
        return (String) getClaims(token).get("role");
    }

    public Long extractUserId(String token) {
        return ((Number) getClaims(token).get("userId")).longValue();
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
