package com.example.springboot.controller;

import com.example.springboot.model.Dojo;
import com.example.springboot.repository.DojoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DojoController {
    @Autowired
    DojoRepository dojoRepo;

    @PostMapping("/saveDojo")
    public Dojo saveDojo (@RequestBody Dojo dojo) {
        return dojoRepo.save(dojo);
    }

    @GetMapping("/getDojo")
    public Iterable<Dojo> getDojo() {
        return dojoRepo.findAll();
    }
}
