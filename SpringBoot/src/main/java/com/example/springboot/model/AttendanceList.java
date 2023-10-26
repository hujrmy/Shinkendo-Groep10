package com.example.springboot.model;


import jakarta.persistence.*;

@Entity
@Table(name="attendance_list")
public class AttendanceList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    @ManyToOne
    private User user;

    @ManyToOne
    private Lesson lesson;

    public AttendanceList(User user, Lesson lesson) {
        this.user = user;
        this.lesson = lesson;
    }

    public AttendanceList() {

    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User username) {
        this.user = username;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    @Override
    public String toString() {
        return "AttendaceList{" +
                "ID=" + ID +
                ", user=" + user +
                '}';
    }
}