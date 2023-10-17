package com.example.springboot.repository;

import com.example.springboot.model.ExerciseLogs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseLogsRepository extends JpaRepository<ExerciseLogs, Integer>{

}
