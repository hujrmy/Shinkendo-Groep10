package com.example.springboot.repository;

import com.example.springboot.model.CurriculumExercises;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculumExercisesRepository extends JpaRepository<CurriculumExercises, Integer> {

    CurriculumExercises findByExerciseID(int exerciseId);

    void deleteByExerciseID(int exerciseId);}
