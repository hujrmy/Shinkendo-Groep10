package com.example.springboot.controller;

import com.example.springboot.model.Lesson;
import com.example.springboot.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LessonController {
    @Autowired
    LessonRepository lessonRepo;

    @PostMapping("/saveLesson")
    public Lesson saveLesson (@RequestBody Lesson lesson) {
        return lessonRepo.save(lesson);
    }

    @GetMapping("/getLesson")
    public Iterable<Lesson> getLesson() {
        return lessonRepo.findAll();
    }
}
