package com.example.springboot.model;

import jakarta.persistence.Entity;

//@Entity
public class User {
    private Rights rights;
    private String name;
    private Dojo dojo;
    private Rank rank;
}
