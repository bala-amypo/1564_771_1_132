package com.example.demo.exception;

public class resourceNotFoundException extends RuntimeException {

    public resourceNotFoundException(String message) {
        super(message);
    }
}
