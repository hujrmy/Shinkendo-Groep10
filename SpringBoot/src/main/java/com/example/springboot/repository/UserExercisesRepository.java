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

    @Query(value = "SELECT e.name, ue.exercise_to_do, ue.exercise_done, ue.last_done " +
            "FROM userexercises ue " +
            "JOIN exercise e ON ue.exercise_id = e.id " +
            "JOIN user u ON ue.user_id = u.id " +
            "JOIN curriculumexercises ce ON ce.exercise_id = e.id " +
            "JOIN curriculum c ON c.id = ce.curriculum_id " +
            "WHERE u.username = :username " +
            "AND u.rank = c.id " +
            "ORDER BY ue.exercise_done ASC", nativeQuery = true)
    List<Object[]> findUserExercises(@Param("username") String username);



    @Modifying
    @Transactional
    @Query("UPDATE UserExercises ue " +
            "SET ue.exerciseToDo = ue.exerciseToDo - 1, ue.exerciseDone = ue.exerciseDone + 1 " +
            "WHERE ue.user.ID = (SELECT u.ID FROM User u WHERE u.username = :username) " +
            "AND ue.exercise.ID = :exercise_id"
            )
    int updateToDoList(@Param("username") String username, @Param("exercise_id") UUID exercise_id);

    @Modifying
    @Transactional
    @Query("UPDATE UserExercises ue " +
            "SET ue.lastDone = local date " +
            "WHERE ue.user.ID = (SELECT u.ID FROM User u WHERE u.username = :username) " +
            "AND ue.exercise.ID = :exercise_id"
    )
    void updateLastDone(@Param("username") String username, @Param("exercise_id") UUID exercise_id);

    boolean existsByID(UUID userExercisesId);

    void deleteByID(UUID userExercisesId);
}
