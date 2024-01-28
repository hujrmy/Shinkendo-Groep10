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
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID ID;
    private LocalDate date;

    public Lesson(LocalDate date) {
        this.date = date;
    }

    public Lesson() {

    }
    @Override
    public String toString() {
        return "Lesson{" +
                "ID=" + ID +
                ", date=" + date +
                '}';
    }

}