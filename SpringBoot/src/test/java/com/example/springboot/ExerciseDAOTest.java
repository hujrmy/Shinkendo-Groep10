package com.example.springboot;

import com.example.springboot.dao.ExerciseDao;
import com.example.springboot.model.Exercise;
import com.example.springboot.repository.ExerciseRepository;
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
public class ExerciseDAOTest {

    @Mock
    private ExerciseRepository exerciseRepository;

    private ExerciseDao SUT;

    @BeforeEach
    void setup() {
        this.SUT = new ExerciseDao(exerciseRepository);
    }

    @Test
    void should_add_exercise_to_repository() {
        Exercise exerciseToAdd = new Exercise();
        exerciseToAdd.setID(1L);
        exerciseToAdd.setName("Sample Exercise");

        when(exerciseRepository.save(exerciseToAdd)).thenReturn(exerciseToAdd);

        Exercise addedExercise = SUT.addExercise(exerciseToAdd);

        assertEquals(1L, addedExercise.getID());
        assertEquals("Sample Exercise", addedExercise.getName());
    }

    @Test
    void should_get_all_exercises_from_repository() {
        List<Exercise> expectedExercises = new ArrayList<>();
        Exercise exercise1 = new Exercise();
        exercise1.setID(1L);
        exercise1.setName("Exercise 1");

        Exercise exercise2 = new Exercise();
        exercise2.setID(2L);
        exercise2.setName("Exercise 2");

        expectedExercises.add(exercise1);
        expectedExercises.add(exercise2);

        when(exerciseRepository.findAll()).thenReturn(expectedExercises);

        List<Exercise> retrievedExercises = SUT.getAllExercises();

        assertEquals(expectedExercises.size(), retrievedExercises.size());
        assertEquals(expectedExercises.get(0).getID(), retrievedExercises.get(0).getID());
        assertEquals(expectedExercises.get(1).getID(), retrievedExercises.get(1).getID());
        assertEquals(expectedExercises.get(0).getName(), retrievedExercises.get(0).getName());
        assertEquals(expectedExercises.get(1).getName(), retrievedExercises.get(1).getName());
    }
}
