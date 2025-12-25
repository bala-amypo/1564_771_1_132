package com.example.barter.exception;

public class GlobalExceptionHandler extends RuntimeException {
    public GlobalException(String message) {
        super(message);
    }
}