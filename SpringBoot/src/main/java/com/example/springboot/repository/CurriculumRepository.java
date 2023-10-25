package com.example.springboot.repository;

import com.example.springboot.model.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CurriculumRepository extends JpaRepository<Curriculum, Integer>{

}
