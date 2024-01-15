package com.example.springboot.repository;

import com.example.springboot.model.*;
import org.hibernate.sql.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserExercisesRepository extends JpaRepository<UserExercises, Integer> {

    @Query(value = "SELECT e.name, ue.exerciseToDo, ue.exerciseDone, ue.lastDone FROM UserExercises ue " +
            "JOIN ue.exercise e " +
            "JOIN ue.user u " +
            "JOIN CurriculumExercises ce ON ce.exercise = e " +
            "JOIN Curriculum c ON c = ce.curriculum " +
            "WHERE u.username = :username " +
            "AND u.rank = c.ID " +
            "ORDER BY ue.exerciseDone ASC ")
    List<Object[]> findUserExercises(@Param("username") String username);

    @Modifying
    @Transactional
    @Query("UPDATE UserExercises ue " +
            "SET ue.exerciseToDo = ue.exerciseToDo - 1, ue.exerciseDone = ue.exerciseDone + 1 " +
            "WHERE ue.user.ID = (SELECT u.ID FROM User u WHERE u.username = :username) " +
            "AND ue.exercise.ID = :exercise_id"
            )
    int updateToDoList(@Param("username") String username, @Param("exercise_id") int exercise_id);
}
