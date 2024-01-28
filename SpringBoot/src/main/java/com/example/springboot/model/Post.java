package com.example.springboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.*;

import java.time.*;
import java.util.*;

@Entity
@Getter
@Setter
@Table(name="post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID ID;

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
