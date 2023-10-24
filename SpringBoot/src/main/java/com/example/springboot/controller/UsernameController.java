package com.example.springboot.controller;

import com.example.springboot.model.User;
import com.example.springboot.repository.UsernameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsernameController {
    @Autowired
    UsernameRepository UsernameRepo;

    @PostMapping("/saveUser")
    public User saveUsername (@RequestBody User save) {
        return UsernameRepo.save(save);
    }

    @GetMapping("/getUser")
    public Iterable<User> getUsername() {
        return UsernameRepo.findAll();
    }
}
