package com.example.springboot.model;

import jakarta.persistence.Entity;

import java.time.LocalDate;

//@Entity
public class Lesson {
    LocalDate date;
    Exercise exercise;
}
