package com.example.springboot.dao;

import com.example.springboot.model.Curriculum;
import com.example.springboot.model.Exercise;
import com.example.springboot.repository.CurriculumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CurriculumDao {
    @Autowired
    private CurriculumRepository curriculumRepository;

    public Curriculum addCurriculum(Curriculum newCurriculum) {
        Curriculum curriculum = this.curriculumRepository.save(newCurriculum);
        return curriculum;
    }

    public List<String> getAllCurriculumNames() {
        List<String> curriculumNames = new ArrayList<>();
        List<Curriculum> allCurriculums = curriculumRepository.findAll();

        for (Curriculum curriculum : allCurriculums) {
            curriculumNames.add(curriculum.getName());
        }

        return curriculumNames;
    }

    public List<String> getAllCurriculumDescriptions() {
        List<String> curriculumDescriptions = new ArrayList<>();
        List<Curriculum> allCurriculums = curriculumRepository.findAll();

        for (Curriculum curriculum : allCurriculums) {
            curriculumDescriptions.add(curriculum.getDescription());
        }

        return curriculumDescriptions;
    }
}
