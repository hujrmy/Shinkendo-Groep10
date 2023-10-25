package com.example.springboot.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;
    private LocalDate date;

    @ManyToOne
    private Exercise exercise;

    public Lesson(LocalDate date, Exercise exercise) {
        this.date = date;
        this.exercise = exercise;
    }

    public Lesson() {

    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
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

    @Override
    public String toString() {
        return "Lesson{" +
                "ID=" + ID +
                ", date=" + date +
                ", exercise=" + exercise +
                '}';
    }

}