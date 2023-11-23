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

    public ArrayList<Exercise> getAllExercisesByCurriculum(long curriculumId) {
        ArrayList<Exercise> exercises = (ArrayList<Exercise>) exerciseRepository.findByCurriculumId(curriculumId);

        if (exercises.isEmpty()) {
            throw new ExercisesNotFoundException("No exercises found for curriculum with ID " + curriculumId);
        }

        return exercises;
    }

    public List<Exercise> getAllExercises() {
        List<Exercise> exercises = exerciseRepository.findAll();
        return exercises;}


//    public List<String> getExerciseMediaByCurriculumId(long curriculumId) {
//        List<String> exerciseMedia = new ArrayList<>();
//        List<Exercise> exercises = this.exerciseRepository.findByCurriculumId(curriculumId);
//
//        for (Exercise exercise : exercises) {
//            exerciseMedia.add(exercise.getMedia());
//        }
//
//        return exerciseMedia;
//    }
//
//    public List<String> getExerciseNamesByCurriculumId(long curriculumId) {
//        List<String> exerciseNames = new ArrayList<>();
//        List<Exercise> exercises = this.exerciseRepository.findByCurriculumId(curriculumId);
//
//        for (Exercise exercise : exercises) {
//            exerciseNames.add(exercise.getName());
//        }
//
//        return exerciseNames;
//    }
}
