package com.example.springboot.model;

public record Exercise(
        String name,
        Note note,
        String media,
        int exerciseCount
) {
}
