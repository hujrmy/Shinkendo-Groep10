package com.example.springboot.controller;

import com.example.springboot.model.ExerciseLogs;
import com.example.springboot.repository.ExerciseLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExerciseLogsController {
    @Autowired
    ExerciseLogsRepository exerciseLogsRepo;

    @PostMapping("/saveExerciseLogs")
    public ExerciseLogs saveExerciseLogs (@RequestBody ExerciseLogs exerciseLogs) {
        return exerciseLogsRepo.save(exerciseLogs);
    }

    @GetMapping("/getExerciseLogs")
    public Iterable<ExerciseLogs> getExerciseLogs() {
        return exerciseLogsRepo.findAll();
    }
}
