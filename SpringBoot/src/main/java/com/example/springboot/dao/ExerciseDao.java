package com.example.springboot.dao;

import com.example.springboot.Exception.ExercisesNotFoundException;
import com.example.springboot.model.Exercise;
import com.example.springboot.model.User;
import com.example.springboot.repository.ExerciseRepository;
import com.example.springboot.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public Exercise getExerciseById(UUID exerciseId) {
        Exercise exercise = exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new ExercisesNotFoundException("Exercise not found with ID " + exerciseId));
        return exercise;
    }

    public List<Exercise> getAllExercises() {
        List<Exercise> exercises = exerciseRepository.findAll();
        return exercises;}


    public boolean deleteExercise(UUID exerciseId) {
        if (exerciseRepository.existsById(exerciseId)) {
            exerciseRepository.deleteById(exerciseId);
            return true;
        }
        return false;
    }

    public Exercise updateExercise(UUID exerciseId, String name, String media) {
        Optional<Exercise> exerciseOptional = exerciseRepository.findById(exerciseId);
        if (exerciseOptional.isPresent()) {
            Exercise exercise = exerciseOptional.get();
            exercise.setName(name);
            exercise.setMedia(media);
            exercise = exerciseRepository.save(exercise);
            return exercise;
        }
        return null;
    }
}
