package com.example.springboot.repository;

import com.example.springboot.model.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CurriculumRepository extends JpaRepository<Curriculum, Integer> {
    @Query("SELECT c FROM Curriculum c ORDER BY c.ID")
    List<Curriculum> findAllOrderedById();
}

