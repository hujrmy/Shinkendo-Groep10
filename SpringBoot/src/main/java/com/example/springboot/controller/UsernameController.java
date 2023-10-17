package com.example.springboot.controller;

import com.example.springboot.model.Username;
import com.example.springboot.repository.UsernameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsernameController {
    @Autowired
    UsernameRepository UsernameRepo;

    @PostMapping("/saveUsername")
    public Username saveUsername (@RequestBody Username save) {
        return UsernameRepo.save(save);
    }

    @GetMapping("/getUsername")
    public Iterable<Username> getUsername() {
        return UsernameRepo.findAll();
    }
}
