package com.example.springboot.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;
    private LocalDate date;

    public Lesson(LocalDate date) {
        this.date = date;
    }

    public Lesson() {

    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
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