package com.example.springboot.controller;

import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserRepository UserRepo;

    @PostMapping("/saveUser")
    public User saveUser (@RequestBody User save) {
        return UserRepo.save(save);
    }

    @GetMapping("/getUser")
    public Iterable<User> getUser() {
        return UserRepo.findAll();
    }
}
