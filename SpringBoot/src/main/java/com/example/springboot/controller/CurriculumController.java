package com.example.springboot.controller;

import com.example.springboot.model.Curriculum;
import com.example.springboot.repository.CurriculumCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/curriculum")
public class CurriculumController {
    private CurriculumCollectionRepository repository;

    public CurriculumController(CurriculumCollectionRepository repository) {
        this.repository = repository;
    }
    @GetMapping("")
    public List<Curriculum> findAll(){
        return repository.findAll();

    }
}
