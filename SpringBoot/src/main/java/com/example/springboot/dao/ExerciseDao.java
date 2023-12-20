package com.example.springboot.dao;

import com.example.springboot.Exception.ExercisesNotFoundException;
import com.example.springboot.model.Exercise;
import com.example.springboot.repository.ExerciseRepository;
import com.example.springboot.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExerciseDao {
    @Autowired
    private ExerciseRepository exerciseRepository;

    public ExerciseDao(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public Exercise addExercise(Exercise newExercise) {
        Exercise exercise = this.exerciseRepository.save(newExercise);
        return exercise;
    }

    public Exercise getExerciseById(long exerciseId) {
        Exercise exercise = exerciseRepository.findById((int) exerciseId)
                .orElseThrow(() -> new ExercisesNotFoundException("Exercise not found with ID " + exerciseId));
        return exercise;
    }

    public List<Exercise> getAllExercises() {
        List<Exercise> exercises = exerciseRepository.findAll();
        return exercises;}


    public boolean deleteExercise(long exerciseId) {
        if (exerciseRepository.existsById((int) exerciseId)) {
            exerciseRepository.deleteById((int) exerciseId);
            return true;
        }
        return false;
    }
}
