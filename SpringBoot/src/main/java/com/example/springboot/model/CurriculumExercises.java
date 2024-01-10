package com.example.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name="curriculumexercises")
public class CurriculumExercises {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;
    @ManyToOne
    @JoinColumn(name = "curriculum_id")
    private Curriculum curriculum;

    public CurriculumExercises() {
    }

    public CurriculumExercises(long ID, Exercise exercise, Curriculum curriculum) {
        this.ID = ID;
        this.exercise = exercise;
        this.curriculum = curriculum;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    @Override
    public String toString() {
        return "CurriculumExercises{" +
                "ID=" + ID +
                ", exercise=" + exercise +
                ", curriculum=" + curriculum +
                '}';
    }
}
