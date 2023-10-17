package com.example.springboot.model;

import jakarta.persistence.Entity;

//@Entity
public class User {
    Rights rights;
    String name;
    Dojo dojo;
    Rank ran;

    public User(Rights rights, String name, Dojo dojo, Rank ran) {
        this.rights = rights;
        this.name = name;
        this.dojo = dojo;
        this.ran = ran;
    }

    public Rights getRights() {
        return rights;
    }

    public void setRights(Rights rights) {
        this.rights = rights;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dojo getDojo() {
        return dojo;
    }

    public void setDojo(Dojo dojo) {
        this.dojo = dojo;
    }

    public Rank getRan() {
        return ran;
    }

    public void setRan(Rank ran) {
        this.ran = ran;
    }
}
