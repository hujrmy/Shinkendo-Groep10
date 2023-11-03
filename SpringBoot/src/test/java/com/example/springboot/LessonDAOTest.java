package com.example.springboot;

import com.example.springboot.dao.LessonDao;
import com.example.springboot.model.Lesson;
import com.example.springboot.repository.LessonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LessonDAOTest {

    @Mock
    private LessonRepository lessonRepository;

    private LessonDao SUT;

    @BeforeEach
    void setup(){
        this.SUT = new LessonDao(lessonRepository);
    }

    @Test
    void should_add_lesson_to_repository(){
        // Arrange
        Lesson lessonToAdd = new Lesson();
        lessonToAdd.setID(1L);
        lessonToAdd.setDate(LocalDate.now());

        when(lessonRepository.save(lessonToAdd)).thenReturn(lessonToAdd);

        // Act
        Lesson addedLesson = SUT.addLesson(lessonToAdd);

        // Assert
        assertEquals(1L, addedLesson.getID());
        assertEquals(LocalDate.now(), addedLesson.getDate());
    }

    @Test
    void should_get_all_lessons_from_repository(){
        // Arrange
        List<Lesson> expectedLessons = new ArrayList<>();
        Lesson lesson1 = new Lesson();
        lesson1.setID(1L);
        lesson1.setDate(LocalDate.now());

        Lesson lesson2 = new Lesson();
        lesson2.setID(2L);
        lesson2.setDate(LocalDate.now().plusDays(1));

        expectedLessons.add(lesson1);
        expectedLessons.add(lesson2);

        when(lessonRepository.findAll()).thenReturn(expectedLessons);

        // Act
        List<Lesson> retrievedLessons = SUT.getAllLessons();

        // Assert
        assertEquals(expectedLessons.size(), retrievedLessons.size());
        assertEquals(expectedLessons.get(0).getID(), retrievedLessons.get(0).getID());
        assertEquals(expectedLessons.get(1).getID(), retrievedLessons.get(1).getID());
        assertEquals(expectedLessons.get(0).getDate(), retrievedLessons.get(0).getDate());
        assertEquals(expectedLessons.get(1).getDate(), retrievedLessons.get(1).getDate());
    }
}
