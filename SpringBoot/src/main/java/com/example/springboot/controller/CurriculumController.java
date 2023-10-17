package com.example.springboot.controller;

import com.example.springboot.model.AttendanceList;
import com.example.springboot.model.Curriculum;
import com.example.springboot.model.Exercise;
import com.example.springboot.repository.AttendanceListRepository;
import com.example.springboot.repository.CurriculumRepository;
import com.example.springboot.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CurriculumController {
    @Autowired
    CurriculumRepository curriculumRepo;

    @PostMapping("/saveCurriculum")
    public Curriculum saveCurriculum (@RequestBody Curriculum curriculum) {
        return curriculumRepo.save(curriculum);
    }

    @GetMapping("/getCurriculum")
    public Iterable<Curriculum> getCurriculum() {
        return curriculumRepo.findAll();
    }
}
