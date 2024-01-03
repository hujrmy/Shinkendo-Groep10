package com.example.springboot.repository;

import com.example.springboot.model.UserExercises;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserExercisesRepository extends JpaRepository<UserExercises, Integer> {
    Optional<UserExercises> findByID(long id);
}
