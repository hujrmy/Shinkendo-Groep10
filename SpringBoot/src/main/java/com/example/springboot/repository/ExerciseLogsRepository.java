package com.example.springboot.repository;

import com.example.springboot.model.ExerciseLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ExerciseLogsRepository extends JpaRepository<ExerciseLogs, Integer>{

}
