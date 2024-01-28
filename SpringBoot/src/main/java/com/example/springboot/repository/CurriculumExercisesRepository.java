package com.example.springboot.repository;

import com.example.springboot.model.CurriculumExercises;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CurriculumExercisesRepository extends JpaRepository<CurriculumExercises, UUID> {

    CurriculumExercises findByID(UUID curriculumExerciseId);

    void deleteByID(UUID curriculumExerciseId);
}
