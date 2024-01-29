package com.example.springboot.repository;

import com.example.springboot.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository

public interface LessonRepository extends JpaRepository<Lesson, UUID>{

}
