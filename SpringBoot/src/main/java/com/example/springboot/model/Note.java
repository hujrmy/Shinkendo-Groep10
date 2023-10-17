package com.example.springboot.model;

import jakarta.persistence.Entity;

//@Entity
public class Note {
    String description;

    public Note(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
