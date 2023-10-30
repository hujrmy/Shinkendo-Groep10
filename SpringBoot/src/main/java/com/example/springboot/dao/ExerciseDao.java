package com.example.springboot.dao;

import com.example.springboot.model.Exercise;
import com.example.springboot.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ExerciseDao {
    @Autowired
    private ExerciseRepository exerciseRepository;

    public Exercise addExercise(Exercise newExercise) {
        Exercise exercise = this.exerciseRepository.save(newExercise);
        return exercise;
    }

    public Exercise getExerciseMediaByCurriculumId(int curriculumId) {
        Optional<Exercise> exercises = this.exerciseRepository.findById(curriculumId);
        return exercises.get();
    }

    public Exercise getExerciseNamesByCurriculumId(int curriculumId) {
        Optional<Exercise> exercises = this.exerciseRepository.findById(curriculumId);
        return exercises.get();
    }
}
