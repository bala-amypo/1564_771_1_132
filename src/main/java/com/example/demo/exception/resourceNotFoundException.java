package com.example.barter.exception;

public class resourceNotException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}