package com.example.springboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "dojo")
public class Dojo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID ID;
    private String name;
    private String place;

    public Dojo(String name, String place) {
        this.name = name;
        this.place = place;
    }

    public Dojo(UUID ID, String name, String place) {
        this.ID = ID;
        this.name = name;
        this.place = place;
    }

    public Dojo() {

    }

    @Override
    public String toString() {
        return "Dojo{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                '}';
    }
}