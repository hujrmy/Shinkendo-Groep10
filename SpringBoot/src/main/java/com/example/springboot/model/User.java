package com.example.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    private String username;
    private String password;
    private Rights rights;
    private String name;

    @ManyToOne
    private Dojo dojo;

    private Rank rank;

    public User(Rights rights, String name, Dojo dojo, Rank rank) {
        this.rights = rights;
        this.name = name;
        this.dojo = dojo;
        this.rank = rank;
    }

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
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

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Username{" +
                "ID=" + ID +
                ", rights=" + rights +
                ", name='" + name + '\'' +
                ", dojo=" + dojo +
                ", rank=" + rank +
                ", username=" + username +
                ", password=" + password +
                '}';
    }
}
