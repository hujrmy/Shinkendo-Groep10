package com.example.springboot.model;

import jakarta.persistence.Entity;

import java.time.LocalDate;

//@Entity
public class Lesson {
    LocalDate date;
    Exercise exercise;

    public Lesson(LocalDate date, Exercise exercise) {
        this.date = date;
        this.exercise = exercise;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
