package com.example.springboot.model;

import java.time.LocalDate;

public record Lesson(
        LocalDate date,
        Exercise exercise
) {
}
