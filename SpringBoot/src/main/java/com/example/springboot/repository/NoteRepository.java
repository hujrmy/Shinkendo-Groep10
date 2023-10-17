package com.example.springboot.repository;

import com.example.springboot.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Integer>{

}
