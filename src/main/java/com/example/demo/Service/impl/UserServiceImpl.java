package com.example.Barter.service.impl;

import org.springframework.stereotype.Service;

import com.example.Barter.model.User;
import com.example.Barter.repository.UserRepository;
import com.example.Barter.service.UserService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new EntityNotFoundException("User not found with email: " + email));
    }
}
