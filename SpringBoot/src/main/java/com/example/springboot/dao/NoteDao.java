package com.example.springboot.dao;

import com.example.springboot.model.Note;
import com.example.springboot.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Component
public class NoteDao {

    @Autowired
    private NoteRepository noteRepository;

    public NoteDao(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note addNote(Note newNote) {
        Note note = this.noteRepository.save(newNote);
        return note;
    }

    public ArrayList<Note> getAllNotes(){
        ArrayList<Note> allNote = (ArrayList<Note>) this.noteRepository.findAll();
        return allNote;
    }

    public boolean deleteNote(UUID noteId){
        if (noteRepository.existsById(noteId)){
            noteRepository.deleteById(noteId);
            return true;
        }
        return false;
    }
}
