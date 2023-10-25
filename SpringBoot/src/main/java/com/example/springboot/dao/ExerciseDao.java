package com.example.springboot.dao;

import com.example.springboot.model.Exercise;
import com.example.springboot.model.Note;
import com.example.springboot.repository.ExerciseRepository;
import com.example.springboot.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ExerciseDao {
    @Autowired
    private ExerciseRepository exerciseRepository;

    public Exercise addExercise(Exercise newExercise) {
        Exercise exercise = this.exerciseRepository.save(newExercise);
        return exercise;
    }

    public ArrayList<Exercise> getAllExercises(){
        ArrayList<Exercise> allExercises = (ArrayList<Exercise>) this.exerciseRepository.findAll();
        return allExercises;
    }
}
