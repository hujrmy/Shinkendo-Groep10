package com.example.springboot.model;


import jakarta.persistence.*;

@Entity
@Table(name="attendence_list")
public class AttendanceList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    @ManyToOne
    private User user;

    public AttendanceList(User user) {
        this.user = user;
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

    @Override
    public String toString() {
        return "AttendaceList{" +
                "ID=" + ID +
                ", user=" + user +
                '}';
    }
}