package com.example.springboot.controller;

import com.example.springboot.model.Rights;
import com.example.springboot.repository.RightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RightsController {
    @Autowired
    RightsRepository rightsRepo;

    @PostMapping("/saveRights")
    public Rights saveRights (@RequestBody Rights rights) {
        return rightsRepo.save(rights);
    }

    @GetMapping("/getRights")
    public Iterable<Rights> getRights() {
        return rightsRepo.findAll();
    }
}
