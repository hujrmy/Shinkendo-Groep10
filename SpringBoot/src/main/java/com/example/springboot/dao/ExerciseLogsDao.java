package com.example.springboot.dao;

import com.example.springboot.model.ExerciseLogs;
import com.example.springboot.repository.ExerciseLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ExerciseLogsDao {
    @Autowired
    private ExerciseLogsRepository exerciseLogsRepository;

    public ExerciseLogs addExerciseLogs(ExerciseLogs newExerciseLogs) {
        ExerciseLogs exerciseLogs = this.exerciseLogsRepository.save(newExerciseLogs);
        return exerciseLogs;
    }

    public ArrayList<ExerciseLogs> getAllExerciseLogs(){
        ArrayList<ExerciseLogs> allExerciseLogs = (ArrayList<ExerciseLogs>) this.exerciseLogsRepository.findAll();
        return allExerciseLogs;
    }
}
