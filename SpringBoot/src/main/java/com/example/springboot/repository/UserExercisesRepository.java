package com.example.springboot.repository;

import com.example.springboot.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;

import java.util.List;

public interface UserExercisesRepository extends JpaRepository<UserExercises, Integer> {
    @Query("SELECT CASE WHEN COUNT(ue) > 0 THEN true ELSE false END FROM UserExercises ue " +
            "JOIN ue.user u " +
            "WHERE u.username = :username")
    Boolean existsByUsername(@Param("username") String username);

    @Query(value = "SELECT e.name, ue.exerciseToDo, ue.exerciseDone, ue.lastDone FROM UserExercises ue " +
            "JOIN ue.exercise e " +
            "JOIN ue.user u " +
            "JOIN CurriculumExercises ce ON ce.exercise = e " +
            "JOIN Curriculum c ON c = ce.curriculum " +
            "WHERE u.username = 'admin' " +
            "AND u.rank = c.ID " +
            "ORDER BY ue.exerciseToDo DESC")
    List<Object[]> findUserExercises(@Param("username") String username);

}
