package com.example.springboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID ID;
    private String name;

    private String media;

    public Exercise(String name, String media) {
        this.name = name;
        this.media = media;
    }

    public Exercise() {

    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
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