package com.example.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name="exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;
    private String name;

    private String media;

    public Exercise(String name, Note note, String media) {
        this.name = name;
        this.media = media;
    }

    public Exercise() {

    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
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