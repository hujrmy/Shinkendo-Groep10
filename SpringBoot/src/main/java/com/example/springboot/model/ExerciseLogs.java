package com.example.springboot.model;

import jakarta.persistence.*;

@Entity
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExerciseLogs that = (ExerciseLogs) o;

        return ID == that.ID;
    }

    @Override
    public int hashCode() {
        return (int) (ID ^ (ID >>> 32));
    }
}
