package com.example.springboot.model;

import jakarta.persistence.Entity;

//@Entity
public class User {
    Rights rights;
    String name;
    Dojo dojo;
    Rank ran;
}
