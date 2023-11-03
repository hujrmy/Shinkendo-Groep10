package com.example.springboot;

import com.example.springboot.dao.NoteDao;
import com.example.springboot.model.Note;
import com.example.springboot.repository.NoteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NoteDAOTest {

    @Mock
    private NoteRepository noteRepository;

    private NoteDao SUT;

    @BeforeEach
    void setup() {
        this.SUT = new NoteDao(noteRepository);
    }

    @Test
    void should_add_note_to_repository() {
        Note noteToAdd = new Note();
        noteToAdd.setID(1L);
        noteToAdd.setDescription("Sample Note");

        when(noteRepository.save(noteToAdd)).thenReturn(noteToAdd);

        Note addedNote = SUT.addNote(noteToAdd);

        assertEquals(1L, addedNote.getID());
        assertEquals("Sample Note", addedNote.getDescription());
    }

    @Test
    void should_get_all_notes_from_repository() {
        List<Note> expectedNotes = new ArrayList<>();
        Note note1 = new Note();
        note1.setID(1L);
        note1.setDescription("Note 1");

        Note note2 = new Note();
        note2.setID(2L);
        note2.setDescription("Note 2");

        expectedNotes.add(note1);
        expectedNotes.add(note2);

        when(noteRepository.findAll()).thenReturn(expectedNotes);

        List<Note> retrievedNotes = SUT.getAllNotes();

        assertEquals(expectedNotes.size(), retrievedNotes.size());
        assertEquals(expectedNotes.get(0).getID(), retrievedNotes.get(0).getID());
        assertEquals(expectedNotes.get(1).getID(), retrievedNotes.get(1).getID());
        assertEquals(expectedNotes.get(0).getDescription(), retrievedNotes.get(0).getDescription());
        assertEquals(expectedNotes.get(1).getDescription(), retrievedNotes.get(1).getDescription());
    }
}
