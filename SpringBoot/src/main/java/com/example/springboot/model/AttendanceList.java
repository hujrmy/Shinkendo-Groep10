package com.example.springboot.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="attendance_list")
public class AttendanceList {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID ID;

    @ManyToOne
    private User user;

    @ManyToOne
    private Exercise exercise;

    @ManyToOne
    private Lesson lesson;

    public AttendanceList(User user, Exercise exercise, Lesson lesson) {
        this.user = user;
        this.exercise = exercise;
        this.lesson = lesson;
    }

    public AttendanceList() {

    }

    @Override
    public String toString() {
        return "AttendanceList{" +
                "ID=" + ID +
                ", user=" + user +
                '}';
    }
}