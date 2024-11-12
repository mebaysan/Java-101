package com.mebaysan.rest_intro.error;

public class StudentNotFoundError extends RuntimeException {
    public StudentNotFoundError(String message) {
        super(message);
    }

}
