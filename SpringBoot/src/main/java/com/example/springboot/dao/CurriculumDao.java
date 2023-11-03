package com.example.springboot.dao;

import com.example.springboot.model.Curriculum;
import com.example.springboot.model.Exercise;
import com.example.springboot.model.Lesson;
import com.example.springboot.repository.CurriculumRepository;
import com.example.springboot.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CurriculumDao {
    @Autowired
    private CurriculumRepository curriculumRepository;

    public CurriculumDao(CurriculumRepository curriculumRepository) {
        this.curriculumRepository = curriculumRepository;
    }

    public Curriculum addCurriculum(Curriculum newCurriculum) {
        Curriculum curriculum = this.curriculumRepository.save(newCurriculum);
        return curriculum;
    }
    public List<Curriculum> getAllCurriculumsOrderedById() {
        List<Curriculum> orderedCurriculums = curriculumRepository.findAllOrderedById();
        return orderedCurriculums;
    }

    public boolean deleteCurriculum(long curriculumId) {
        if (curriculumRepository.existsById((int) curriculumId)) {
            curriculumRepository.deleteById((int) curriculumId);
            return true;
        }
        return false;
    }

    public Curriculum updateCurriculum(long curriculumId, String newName, String newDescription) {
        Optional<Curriculum> curriculumOptional = curriculumRepository.findById((int) curriculumId);
        if (curriculumOptional.isPresent()) {
            Curriculum curriculum = curriculumOptional.get();
            curriculum.setName(newName);
            curriculum.setDescription(newDescription);
            curriculum = curriculumRepository.save(curriculum);
            return curriculum;
        }
        return null;
    }


}
