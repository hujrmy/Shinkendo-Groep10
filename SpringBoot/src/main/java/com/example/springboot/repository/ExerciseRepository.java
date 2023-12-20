package com.example.springboot.repository;

import com.example.springboot.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Integer>{
    @Query("SELECT e FROM Exercise e WHERE e.curriculum.ID = :curriculumId")
    List<Exercise> findByCurriculumId(@Param("curriculumId") long curriculumId);

}
