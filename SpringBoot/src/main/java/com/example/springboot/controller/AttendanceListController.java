package com.example.springboot.controller;


import com.example.springboot.model.AttendanceList;
import com.example.springboot.repository.AttendanceListRepository;
import com.example.springboot.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttendanceListController {

    @Autowired
    AttendanceListRepository attendanceListRepo;

    @PostMapping("/saveAttendanceList")
    public AttendanceList saveAttendanceList (@RequestBody AttendanceList attendanceList) {
        return attendanceListRepo.save(attendanceList);
    }

    @GetMapping("/getAttendanceList")
    public Iterable<AttendanceList> getAttendanceList() {
        return attendanceListRepo.findAll();
    }
}