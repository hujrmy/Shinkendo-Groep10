package com.example.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name="exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;
    private String name;

    @ManyToOne
    private Note note;
    private String media;
    private int exerciseCount;

    @ManyToOne
    private Curriculum curriculum;

    public Exercise(String name, Note note, String media, int exerciseCount, Curriculum curriculum) {
        this.name = name;
        this.note = note;
        this.media = media;
        this.exerciseCount = exerciseCount;
        this.curriculum = curriculum;
    }

    public Exercise() {

    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
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

    @Override
    public String toString() {
        return "Exercise{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", note=" + note +
                ", media='" + media + '\'' +
                ", exerciseCount=" + exerciseCount +
                ", curriculum=" + curriculum +
                '}';
    }
}