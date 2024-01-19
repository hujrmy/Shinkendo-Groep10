package com.example.springboot.dao;

import com.example.springboot.Exception.ExercisesNotFoundException;
import com.example.springboot.model.Exercise;
import com.example.springboot.model.Lesson;
import com.example.springboot.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class LessonDao {
    @Autowired
    private LessonRepository lessonRepository;

    public LessonDao(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public Lesson addLesson(Lesson newLesson) {
        Lesson lesson = this.lessonRepository.save(newLesson);
        return lesson;
    }

    public ArrayList<Lesson> getAllLessons(){
        ArrayList<Lesson> AllLessons = (ArrayList<Lesson>) this.lessonRepository.findAll();
        return AllLessons;
    }

    public Lesson getLessonById(long lessonId) {
        Lesson lesson = lessonRepository.findById((int) lessonId)
                .orElseThrow(() -> new ExercisesNotFoundException("Exercise not found with ID " + lessonId));
        return lesson;
    }

    public boolean deleteLesson(long lessonId) {
        if (lessonRepository.existsById((int) lessonId)) {
            lessonRepository.deleteById((int) lessonId);
            return true;
        }
        return false;
    }

}
