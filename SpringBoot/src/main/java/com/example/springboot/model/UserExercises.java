package com.example.springboot.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="userexercises")
public class UserExercises {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    @ManyToOne
    private User user;
    @ManyToOne
    private Exercise exercise;
    private int exerciseToDo;
    private int exerciseDone;

    private Date lastDone;

    public UserExercises() {
    }

    public UserExercises(long ID, User user, Exercise exercise, int exerciseToDo, int exerciseDone, Date lastDone) {
        this.ID = ID;
        this.user = user;
        this.exercise = exercise;
        this.exerciseToDo = exerciseToDo;
        this.exerciseDone = exerciseDone;
        this.lastDone = lastDone;
    }

    public Date getLastDone() {
        return lastDone;
    }

    public void setLastDone(Date lastDone) {
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