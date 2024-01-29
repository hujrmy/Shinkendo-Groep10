package com.example.springboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID ID;
    private LocalDate date;

    public Lesson(LocalDate date) {
        this.date = date;
    }

    public Lesson() {

    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
  
    @Override
    public String toString() {
        return "Lesson{" +
                "ID=" + ID +
                ", date=" + date +
                '}';
    }

}