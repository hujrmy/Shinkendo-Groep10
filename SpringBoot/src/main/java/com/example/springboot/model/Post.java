package com.example.springboot.model;

import jakarta.persistence.*;
import org.springframework.cglib.core.*;

import java.time.*;
import java.util.*;

@Entity
@Table(name="post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    private String title;
    private String description;
    private String link;
    private LocalDate date;

    @ManyToOne
    private User user;

    public Post(String title, String description, String link, LocalDate date, User user) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.date = date;
        this.user = user;
    }

    public Post() {

    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                ", date=" + date +
                ", user=" + user +
                '}';
    }
}
