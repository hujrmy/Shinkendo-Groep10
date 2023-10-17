package com.example.springboot.controller;

import com.example.springboot.model.Exercise;
import com.example.springboot.model.ExerciseLogs;
import com.example.springboot.model.Rank;
import com.example.springboot.repository.ExerciseLogsRepository;
import com.example.springboot.repository.ExerciseRepository;
import com.example.springboot.repository.RankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RankController {
    @Autowired
    RankRepository rankRepo;

    @PostMapping("/saveRank")
    public Rank saveRank (@RequestBody Rank rank) {
        return rankRepo.save(rank);
    }

    @GetMapping("/getRank")
    public Iterable<Rank> getRank() {
        return rankRepo.findAll();
    }
}
