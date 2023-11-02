package com.example.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name="note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;
    private String description;
    @ManyToOne
    private User user;

    @ManyToOne
    private Exercise exercise;

    public Note(String description, User user, Exercise exercise) {
        this.description = description;
        this.user = user;
        this.exercise = exercise;
    }

    public Note() {

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Note{" +
                "ID=" + ID +
                ", description='" + description + '\'' +
                ", user=" + user +
                ", exercise=" + exercise +
                '}';
    }
}
