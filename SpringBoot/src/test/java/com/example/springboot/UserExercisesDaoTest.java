package com.example.springboot;

import com.example.springboot.dao.*;
import com.example.springboot.model.*;
import com.example.springboot.repository.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;

import java.time.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserExercisesDaoTest {

    @Mock
    private UserExercisesRepository userExercisesRepository;

    private UserExercisesDao SUT;

    @BeforeEach
    void setup() {
        this.SUT = new UserExercisesDao(userExercisesRepository);
    }

    @Test
    void updateDoneInUserExercises() {
        String username = "testUser";
        LocalDate localDate = LocalDate.now();

        Exercise exercise = new Exercise();
//        exercise.setID(1);
        exercise.setName("Exercise1");

        User user = new User();
        user.setID(UUID.randomUUID());

        UserExercises userExercises = new UserExercises();
        userExercises.setID(1L);
        userExercises.setExerciseDone(4);
        userExercises.setExerciseToDo(0);
        userExercises.setLastDone(localDate);
        userExercises.setExercise(exercise);
        userExercises.setUser(user);

        when(userExercisesRepository.updateToDoList(username, 1)).thenReturn(1);

        int result = SUT.updateToDo(username, 1);
        assertEquals(1, result);
    }

    @Test
    void findTheExercisesToShowUser() {
        List<Object[]> list = new ArrayList<>();
        String username = "testUser";
        LocalDate localDate = LocalDate.now();

        Exercise exercise = new Exercise();
//        exercise.setID(1L);
        exercise.setName("Exercise1");

        User user = new User();
        user.setID(UUID.randomUUID());

        UserExercises userExercises = new UserExercises();
        userExercises.setID(1L);
        userExercises.setExerciseDone(4);
        userExercises.setExerciseToDo(0);
        userExercises.setLastDone(localDate);
        userExercises.setExercise(exercise);
        userExercises.setUser(user);

        Object[] objects = new Object[]{
                userExercises.getExercise().getName(),
                userExercises.getExerciseToDo(),
                userExercises.getExerciseDone(),
                userExercises.getLastDone()
        };

        list.add(objects);

        when(userExercisesRepository.findUserExercises(username)).thenReturn(list);

        List<Object[]> result = SUT.findUserExercisesByUsername(username);

        assertEquals(1, result.size());

        assertEquals(list, result);
    }
}