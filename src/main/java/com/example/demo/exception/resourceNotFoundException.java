package com.example.barter.exception;

public class resourceNotFoundException extends RuntimeException {
    public resourceNotFoundException(String message) {
        super(message);
    }
}