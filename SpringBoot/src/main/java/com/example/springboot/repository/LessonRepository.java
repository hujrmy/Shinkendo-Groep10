package com.example.springboot.repository;

import com.example.springboot.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Integer>{

}
