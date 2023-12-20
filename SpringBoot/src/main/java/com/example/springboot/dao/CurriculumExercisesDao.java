package com.example.springboot.dao;

import com.example.springboot.model.CurriculumExercises;
import com.example.springboot.model.UserExercises;
import com.example.springboot.repository.CurriculumExercisesRepository;
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

    public boolean deleteCurriculumExercises(long curriculumExercisesId){
        if(curriculumExercisesRepository.existsById((int) curriculumExercisesId)) {
            curriculumExercisesRepository.deleteById((int) curriculumExercisesId);
            return true;
        }
        return false;
    }


}
