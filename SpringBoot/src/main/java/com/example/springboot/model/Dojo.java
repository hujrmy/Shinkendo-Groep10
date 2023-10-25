package com.example.springboot.model;

import jakarta.persistence.*;

@Entity
public class Dojo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;
    private String name;
    private String place;

    public Dojo(String name, String place) {
        this.name = name;
        this.place = place;
    }

    public Dojo() {

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