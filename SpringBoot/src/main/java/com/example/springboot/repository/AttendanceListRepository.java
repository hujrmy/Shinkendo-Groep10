package com.example.springboot.repository;

import com.example.springboot.model.AttendanceList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceListRepository extends JpaRepository<AttendanceList, Integer>{

}
