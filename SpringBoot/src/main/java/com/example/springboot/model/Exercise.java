package com.example.springboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID ID;
    private String name;

    private String media;

    public Exercise(String name, String media) {
        this.name = name;
        this.media = media;
    }

    public Exercise() {

    }
    @Override
    public String toString() {
        return "Exercise{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", media='" + media + '\'' +
                '}';
    }
}