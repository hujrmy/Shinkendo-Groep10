package com.example.springboot.controller;


import com.example.springboot.model.Exercise;
import com.example.springboot.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExerciseController {

    @Autowired
    ExerciseRepository exerciseRepo;
    
    @PostMapping("/saveExercise")
    public Exercise saveExercise (@RequestBody Exercise exercise) {
        return exerciseRepo.save(exercise);
    }
}
