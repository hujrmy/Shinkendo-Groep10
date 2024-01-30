package com.example.springboot.repository;

import com.example.springboot.model.*;
import org.hibernate.sql.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface UserExercisesRepository extends JpaRepository<UserExercises, UUID> {
    @Query(value = "SELECT e.name, ue.exerciseToDo, ue.exerciseDone, ue.lastDone " +
            "FROM UserExercises ue " +
            "JOIN Exercise e ON ue.exercise.ID = e.ID " +
            "JOIN User u ON ue.user.ID = u.ID " +
            "JOIN CurriculumExercises ce ON ce.exercise.ID = e.ID " +
            "JOIN Curriculum c ON c.ID = ce.curriculum.ID " +
            "WHERE u.ID = :userId " +
            "AND u.rank = c.name " +
            "ORDER BY ue.exerciseDone ASC")
    List<Object[]> findUserExercises(@Param("userId") UUID userId);



    @Modifying
    @Transactional
    @Query("UPDATE UserExercises ue " +
            "SET ue.exerciseDone = ue.exerciseDone + 1 " +
            "WHERE ue.user.ID = :userId " +
            "AND ue.exercise.ID = :exercise_id"
            )
    int updateToDoList(@Param("userId") UUID userId, @Param("exercise_id") UUID exercise_id);

    @Modifying
    @Transactional
    @Query("UPDATE UserExercises ue " +
            "SET ue.lastDone = local date " +
            "WHERE ue.user.ID = :userId " +
            "AND ue.exercise.ID = :exercise_id"
    )
    void updateLastDone(@Param("userId") UUID userId, @Param("exercise_id") UUID exercise_id);

    boolean existsByID(UUID userExercisesId);

    void deleteByID(UUID userExercisesId);
}
