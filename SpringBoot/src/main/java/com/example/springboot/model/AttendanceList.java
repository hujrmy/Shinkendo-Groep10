package com.example.springboot.model;


import jakarta.persistence.*;

@Entity
public class AttendanceList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    @ManyToOne
    private Username username;

    public AttendanceList(Username username) {
        this.username = username;
    }

    public AttendanceList() {

    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Username getUser() {
        return username;
    }
    public void setUser(Username username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "AttendaceList{" +
                "ID=" + ID +
                ", user=" + username +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttendanceList that = (AttendanceList) o;

        return ID == that.ID;
    }

    @Override
    public int hashCode() {
        return (int) (ID ^ (ID >>> 32));
    }


}
