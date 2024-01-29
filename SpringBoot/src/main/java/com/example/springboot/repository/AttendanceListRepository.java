package com.example.springboot.repository;

import com.example.springboot.model.AttendanceList;
import com.example.springboot.model.Exercise;
import com.example.springboot.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository

public interface AttendanceListRepository extends JpaRepository<AttendanceList, UUID>{

    boolean existsById(UUID id);

    void deleteById(UUID id);
}
