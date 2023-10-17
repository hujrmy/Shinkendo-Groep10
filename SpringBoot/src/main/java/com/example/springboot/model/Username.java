package com.example.springboot.model;

import jakarta.persistence.*;

@Entity
public class Username {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;
    private Rights rights;
    private String name;

    @ManyToOne
    private Dojo dojo;

    private Rank rank;

    public Username(Rights rights, String name, Dojo dojo, Rank rank) {
        this.rights = rights;
        this.name = name;
        this.dojo = dojo;
        this.rank = rank;
    }

    public Username() {

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
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Username username = (Username) o;

        return ID == username.ID;
    }

    @Override
    public int hashCode() {
        return (int) (ID ^ (ID >>> 32));
    }
}
