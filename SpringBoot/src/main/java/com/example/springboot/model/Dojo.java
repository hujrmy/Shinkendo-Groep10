package com.example.springboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "dojo")
public class Dojo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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