package com.example.springboot.model;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="attendance_list")
public class AttendanceList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID ID;

    @ManyToOne
    private User user;

    @ManyToOne
    private Exercise exercise;

    @ManyToOne
    private Lesson lesson;

    public AttendanceList(User user, Exercise exercise, Lesson lesson) {
        this.user = user;
        this.exercise = exercise;
        this.lesson = lesson;
    }

    public AttendanceList() {

    }


    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User username) {
        this.user = username;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Lesson getLesson() {
        return lesson;
    }

    @Override
    public String toString() {
        return "AttendanceList{" +
                "ID=" + ID +
                ", user=" + user +
                '}';
    }
}