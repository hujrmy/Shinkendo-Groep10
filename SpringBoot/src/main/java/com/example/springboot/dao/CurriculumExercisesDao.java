package com.example.springboot.dao;

import com.example.springboot.model.CurriculumExercises;
import com.example.springboot.repository.CurriculumExercisesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CurriculumExercisesDao {

    @Autowired
    private CurriculumExercisesRepository curriculumExercisesRepository;

    public CurriculumExercises addCurriculumExercises(CurriculumExercises newCurriculumExercises){
        CurriculumExercises curriculumExercises = this.curriculumExercisesRepository.save(newCurriculumExercises);
        return curriculumExercises;
    }

    public ArrayList<CurriculumExercises> getAllCurriculumExercises(){
        ArrayList<CurriculumExercises> curriculumExercises = (ArrayList<CurriculumExercises>) this.curriculumExercisesRepository.findAll();
        return curriculumExercises;
    }

    @Transactional
    public boolean deleteCurriculumExercisesByExerciseId(long curriculumExerciseId){
        curriculumExercisesRepository.deleteByID((int) curriculumExerciseId);
        return curriculumExercisesRepository.findByID((int) curriculumExerciseId) == null;
    }


}
