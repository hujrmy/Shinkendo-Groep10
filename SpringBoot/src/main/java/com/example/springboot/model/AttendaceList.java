package com.example.springboot.model;


import jakarta.persistence.*;

@Entity
public class AttendaceList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    @ManyToOne
    private User user;

    public AttendaceList(User user) {
        this.user = user;
    }

    public AttendaceList() {

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

    public void setUser(User user) {
        this.user = user;
    }
}
