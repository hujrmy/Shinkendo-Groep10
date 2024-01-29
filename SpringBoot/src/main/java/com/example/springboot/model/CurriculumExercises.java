package com.example.springboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="curriculumexercises")
public class CurriculumExercises {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID ID;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;
    @ManyToOne
    @JoinColumn(name = "curriculum_id")
    private Curriculum curriculum;

    public CurriculumExercises() {
    }

    public CurriculumExercises(UUID ID, Exercise exercise, Curriculum curriculum) {
        this.ID = ID;
        this.exercise = exercise;
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
