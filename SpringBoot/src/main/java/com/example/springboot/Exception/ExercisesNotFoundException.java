package com.example.springboot.Exception;

public class ExercisesNotFoundException extends RuntimeException {
    public ExercisesNotFoundException(String message) {
        super(message);
    }

    public ExercisesNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
