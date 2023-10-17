package com.example.springboot.repository;

import com.example.springboot.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ExerciseRepository extends JpaRepository<Exercise, Integer>{

}
