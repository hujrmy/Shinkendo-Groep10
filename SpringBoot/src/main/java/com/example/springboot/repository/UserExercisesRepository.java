package com.example.springboot.repository;

import com.example.springboot.model.UserExercises;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserExercisesRepository extends JpaRepository<UserExercises, Integer> {

}
