package com.example.springboot.dao;

import com.example.springboot.model.Exercise;
import com.example.springboot.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExerciseDao {
    @Autowired
    private ExerciseRepository exerciseRepository;

    public Exercise addExercise(Exercise newExercise) {
        Exercise exercise = this.exerciseRepository.save(newExercise);
        return exercise;
    }

    public List<String> getExerciseNamesByCurriculumId(long curriculumId) {
        List<String> exerciseNames = new ArrayList<>();
        List<Exercise> exercises = this.exerciseRepository.findByCurriculumId(curriculumId);

        for (Exercise exercise : exercises) {
            exerciseNames.add(exercise.getName());
        }

        return exerciseNames;
    }
}
