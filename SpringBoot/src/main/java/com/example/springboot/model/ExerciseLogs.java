package com.example.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name="exercise_logs")
public class ExerciseLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    @ManyToOne
    private Lesson lesson;

    public ExerciseLogs(Lesson lesson) {
        this.lesson = lesson;
    }

    public ExerciseLogs() {

    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    @Override
    public String toString() {
        return "ExerciseLogs{" +
                "ID=" + ID +
                ", lesson=" + lesson +
                '}';
    }

}