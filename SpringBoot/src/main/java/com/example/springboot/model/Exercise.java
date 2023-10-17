package com.example.springboot.model;

import jakarta.persistence.Entity;

//@Entity

public class Exercise {
    private String name;
    private Note note;
    private String media;
    private int exerciseCount;

    public Exercise(String name, Note note, String media, int exerciseCount) {
        this.name = name;
        this.note = note;
        this.media = media;
        this.exerciseCount = exerciseCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public int getExerciseCount() {
        return exerciseCount;
    }

    public void setExerciseCount(int exerciseCount) {
        this.exerciseCount = exerciseCount;
    }
}
