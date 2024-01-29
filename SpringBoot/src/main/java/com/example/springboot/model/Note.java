package com.example.springboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID ID;
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
