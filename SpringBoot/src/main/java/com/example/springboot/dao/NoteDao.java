package com.example.springboot.dao;

import com.example.springboot.model.Note;
import com.example.springboot.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NoteDao {

    @Autowired
    private NoteRepository noteRepository;

    public Note addNote(Note newNote) {
        Note note = this.noteRepository.save(newNote);
        return note;
    }

    public List<Note> getAllNotes(){
        List<Note> allNotes = (ArrayList<Note>) this.noteRepository.findAll();
        return allNotes;
    }
}
