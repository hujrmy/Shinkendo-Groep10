package com.example.springboot.controller;

import com.example.springboot.model.Note;
import com.example.springboot.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class NoteController {
    @Autowired
    NoteRepository noteRepo;

    @PostMapping("/saveNote")
    public Note savenote (@RequestBody Note note) {
        return noteRepo.save(note);
    }

    @GetMapping("/getNote")
    public Iterable<Note> getnote() {
        return noteRepo.findAll();
    }
}
