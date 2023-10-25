package com.example.springboot.dao;

import com.example.springboot.model.Lesson;
import com.example.springboot.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class LessonDao {
    @Autowired
    private LessonRepository lessonRepository;

    public Lesson addLesson(Lesson newLesson) {
        Lesson lesson = this.lessonRepository.save(newLesson);
        return lesson;
    }

    public ArrayList<Lesson> getAllLessons(){
        ArrayList<Lesson> AllLessons = (ArrayList<Lesson>) this.lessonRepository.findAll();
        return AllLessons;
    }

}
