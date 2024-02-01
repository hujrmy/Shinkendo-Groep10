package com.example.springboot;

import com.example.springboot.dao.CurriculumDao;
import com.example.springboot.dao.LessonDao;
import com.example.springboot.model.Curriculum;
import com.example.springboot.model.Lesson;
import com.example.springboot.repository.CurriculumRepository;
import com.example.springboot.repository.LessonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CurriculumDAOTest {

    @Mock
    private CurriculumRepository curriculumRepository;
    private CurriculumDao SUT;

    @BeforeEach
    void setup(){
        this.SUT = new CurriculumDao(curriculumRepository);
    }

    @Test
    void should_add_curriculum_to_repository(){
        Curriculum newCurriculum = new Curriculum();
        newCurriculum.setID(UUID.randomUUID());
        newCurriculum.setName("newCurriculum");
        newCurriculum.setDescription("new curriculum");

        when(curriculumRepository.save(newCurriculum)).thenReturn(newCurriculum);

        Curriculum addedCurriculum = SUT.addCurriculum(newCurriculum);

        assertEquals("newCurriculum", addedCurriculum.getName());
        assertEquals("new curriculum", addedCurriculum.getDescription());
    }

    @Test
    void should_get_all_curriculums_by_id_from_repository(){
        List<Curriculum> curriculums = new ArrayList<>();
        Curriculum curriculum1 = new Curriculum();
        curriculum1.setID(UUID.randomUUID());
        curriculum1.setName("newCurriculum1");
        curriculum1.setDescription("new curriculum 1");

        Curriculum curriculum2 = new Curriculum();
        curriculum2.setID(UUID.randomUUID());
        curriculum2.setName("newCurriculum2");
        curriculum2.setDescription("new curriculum 2");

        curriculums.add(curriculum1);
        curriculums.add(curriculum2);

        when(curriculumRepository.findAllOrderedById()).thenReturn(curriculums);

        List<Curriculum> returnCurriculums = SUT.getAllCurriculumsOrderedById();

        assertEquals(curriculums.size(), returnCurriculums.size());
        assertEquals(curriculums.get(0).getID(), returnCurriculums.get(0).getID());
        assertEquals(curriculums.get(1).getID(), returnCurriculums.get(1).getID());
        assertEquals(curriculums.get(0).getName(), returnCurriculums.get(0).getName());
        assertEquals(curriculums.get(1).getName(), returnCurriculums.get(1).getName());
        assertEquals(curriculums.get(0).getDescription(), returnCurriculums.get(0).getDescription());
        assertEquals(curriculums.get(1).getDescription(), returnCurriculums.get(1).getDescription());
    }
}
