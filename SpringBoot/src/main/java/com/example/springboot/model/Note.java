package com.example.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name="note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;
    private String description;

    public Note(String description) {
        this.description = description;
    }

    public Note() {

    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
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
                '}';
    }
}
