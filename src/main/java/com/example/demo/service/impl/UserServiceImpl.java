// package com.example.demo.service.impl;

// import com.example.demo.model.AppUser;
// import com.example.demo.repository.AppUserRepository;
// import com.example.demo.security.JwtUtil;
// import com.example.demo.service.UserService;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// @Service
// public class UserServiceImpl implements UserService {

//     private final AppUserRepository appUserRepository;
//     private final JwtUtil jwtUtil;
//     private final PasswordEncoder passwordEncoder;

//     public UserServiceImpl(AppUserRepository appUserRepository, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
//         this.appUserRepository = appUserRepository;
//         this.jwtUtil = jwtUtil;
//         this.passwordEncoder = passwordEncoder;
//     }

//     @Override
//     public AppUser findByEmail(String email) {
//         return appUserRepository.findByEmail(email)
//                 .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
//     }

//     @Override
//     public AppUser register(AppUser user) {
//         // Check if email exists
//         if (appUserRepository.findByEmail(user.getEmail()).isPresent()) {
//             throw new RuntimeException("Email already exists");
//         }

//         // Encode password
//         user.setPassword(passwordEncoder.encode(user.getPassword()));
//         return appUserRepository.save(user);
//     }

//     @Override
//     public String login(String email, String password) {
//         AppUser user = findByEmail(email);
//         if (!passwordEncoder.matches(password, user.getPassword())) {
//             throw new RuntimeException("Invalid credentials");
//         }
//         return jwtUtil.generateToken(user.getEmail(), user.getRole(), user.getId());
//     }
// }


package com.example.demo.service;

import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(AppUserRepository appUserRepository,
                           PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AppUser register(AppUser user) {

        // ✅ CRITICAL FIX: always encode password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return appUserRepository.save(user);
    }

    @Override
    public AppUser findByEmail(String email) {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found: " + email));
    }
}
