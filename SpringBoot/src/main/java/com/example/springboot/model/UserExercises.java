package com.example.springboot.model;

import jakarta.persistence.*;
import org.springframework.cglib.core.*;

import java.time.*;
import java.util.Date;

@Entity
@Table(name="userexercises")
public class UserExercises {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;
    private int exerciseToDo;
    private int exerciseDone;

    private LocalDate lastDone;

    public UserExercises() {
    }

    public UserExercises(long ID, User user, Exercise exercise, int exerciseToDo, int exerciseDone, LocalDate lastDone) {
        this.ID = ID;
        this.user = user;
        this.exercise = exercise;
        this.exerciseToDo = exerciseToDo;
        this.exerciseDone = exerciseDone;
        this.lastDone = lastDone;
    }

    public LocalDate getLastDone() {
        return lastDone;
    }

    public void setLastDone(LocalDate lastDone) {
        this.lastDone = lastDone;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public int getExerciseToDo() {
        return exerciseToDo;
    }

    public void setExerciseToDo(int exerciseToDo) {
        this.exerciseToDo = exerciseToDo;
    }

    public int getExerciseDone() {
        return exerciseDone;
    }

    public void setExerciseDone(int exerciseDone) {
        this.exerciseDone = exerciseDone;
    }

    @Override
    public String toString() {
        return "UserExercises{" +
                "ID=" + ID +
                ", user=" + user +
                ", exercise=" + exercise +
                ", exerciseToDo=" + exerciseToDo +
                ", exerciseDone=" + exerciseDone +
                '}';
    }
}
