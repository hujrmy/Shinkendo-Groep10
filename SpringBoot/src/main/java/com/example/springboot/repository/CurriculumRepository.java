package com.example.springboot.repository;

import com.example.springboot.model.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculumRepository extends JpaRepository<Curriculum, Integer>{

}
