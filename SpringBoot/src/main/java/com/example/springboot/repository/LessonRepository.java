package com.example.springboot.repository;

import com.example.springboot.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;
import java.util.UUID;

@Repository

public interface LessonRepository extends CrudRepository<Lesson, UUID> {

    @Query("SELECT l FROM Lesson l WHERE l.ID = :lessonId")
    Lesson findByUuid(UUID lessonId);

}
