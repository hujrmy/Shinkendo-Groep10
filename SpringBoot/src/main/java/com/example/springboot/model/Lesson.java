package com.example.springboot.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;
    private LocalDate date;

    @ManyToOne
    private AttendanceList attendance;

    public Lesson(LocalDate date, AttendanceList attendance) {
        this.date = date;
        this.attendance = attendance;
    }

    public Lesson() {

    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public AttendanceList getAttendance() {
        return attendance;
    }

    public void setAttendance(AttendanceList attendance) {
        this.attendance = attendance;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "ID=" + ID +
                ", date=" + date +
                ", attendance=" + attendance +
                '}';
    }

}