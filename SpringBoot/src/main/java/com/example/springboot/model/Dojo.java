package com.example.springboot.model;

import jakarta.persistence.Entity;

//@Entity

public class Dojo {
    String name;
    String place;

    public Dojo(String name, String place) {
        this.name = name;
        this.place = place;
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
}
