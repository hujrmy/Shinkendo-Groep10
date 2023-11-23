package com.example.springboot.repository;

import com.example.springboot.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface NoteRepository extends JpaRepository<Note, Integer>{

}
