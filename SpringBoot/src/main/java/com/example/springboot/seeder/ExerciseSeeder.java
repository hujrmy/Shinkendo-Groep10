package com.example.springboot.seeder;

import com.example.springboot.model.Curriculum;
import com.example.springboot.model.Exercise;
import com.example.springboot.model.Note;
import com.example.springboot.repository.CurriculumRepository;
import com.example.springboot.repository.ExerciseRepository;
import com.example.springboot.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ExerciseSeeder implements CommandLineRunner {

    private final ExerciseRepository exerciseRepository;
    private final CurriculumRepository curriculumRepository;
    private final NoteRepository noteRepository;

    @Autowired
    public ExerciseSeeder(ExerciseRepository exerciseRepository, CurriculumRepository curriculumRepository, NoteRepository noteRepository) {
        this.exerciseRepository = exerciseRepository;
        this.curriculumRepository = curriculumRepository;
        this.noteRepository = noteRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Eerst maken we een Curriculum en een Note
        Curriculum curriculum = new Curriculum("Voorbeeld Curriculum", "Dit is een voorbeeld curriculum.");
        curriculumRepository.save(curriculum);

        Note note = new Note("Voorbeeld Notitie");
        noteRepository.save(note);

        // Vervolgens maken we een Exercise en koppelen deze aan Curriculum en Note
        Exercise exercise = new Exercise("Voorbeeld Oefening", note, "voorbeeld_media.jpg", 5, curriculum);
        exerciseRepository.save(exercise);

        // Je kunt hier meer Exercise-objecten maken en deze opslaan zoals hierboven.
    }
}
