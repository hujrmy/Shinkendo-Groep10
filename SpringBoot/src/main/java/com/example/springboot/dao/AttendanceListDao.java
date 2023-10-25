package com.example.springboot.dao;

import com.example.springboot.model.AttendanceList;
import com.example.springboot.repository.AttendanceListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AttendanceListDao {

    @Autowired
    private AttendanceListRepository attendanceListRepository;

    public AttendanceList addAttendance(AttendanceList newattendanceList) {
        AttendanceList attendanceList = this.attendanceListRepository.save(newattendanceList);
        return attendanceList;
    }

    public ArrayList<AttendanceList> getAllAttendance(){
        ArrayList<AttendanceList> attendanceLists = (ArrayList<AttendanceList>) this.attendanceListRepository.findAll();
        return attendanceLists;
    }

}
