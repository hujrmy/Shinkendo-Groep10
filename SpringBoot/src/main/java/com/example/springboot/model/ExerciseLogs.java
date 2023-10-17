package com.example.springboot.model;

import jakarta.persistence.Entity;

//@Entity
public class ExerciseLogs {
    private Lesson lesson;

    public ExerciseLogs(Lesson lesson) {
        this.lesson = lesson;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
