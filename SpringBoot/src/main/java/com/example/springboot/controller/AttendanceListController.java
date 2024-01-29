package com.example.springboot.controller;


import com.example.springboot.dao.AttendanceListDao;
import com.example.springboot.model.ApiResponse;
import com.example.springboot.model.AttendanceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/attendanceList")
public class AttendanceListController {

    private final AttendanceListDao attendanceListDao;

    @Autowired
    public AttendanceListController(AttendanceListDao attendanceListDao) {
        this.attendanceListDao = attendanceListDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getAllAttendance(){
        return new ApiResponse(HttpStatus.ACCEPTED, this.attendanceListDao.getAllAttendance());
    }

    @RequestMapping(value ="/lesson/{lessonId}", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getAttendanceByLesson(@PathVariable UUID lessonId) {
        return new ApiResponse(HttpStatus.ACCEPTED, this.attendanceListDao.getAttendancesByLessonId(lessonId));
    }

    @RequestMapping(value ="", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse addAttendance(@RequestBody AttendanceList newDao){
        AttendanceList attendanceList = this.attendanceListDao.addAttendance(newDao);
        return new ApiResponse(HttpStatus.ACCEPTED, attendanceList);
    }

    @DeleteMapping("/delete/{lessonId}")
    @ResponseBody
    public ApiResponse deleteAttendanceByLesson(@PathVariable long lessonId) {
        if (attendanceListDao.deleteAttendanceByLesson(lessonId)) {
            return new ApiResponse(HttpStatus.ACCEPTED, "Attendance(s) with LessonID " + lessonId + " has been deleted.");
        } else {
            return new ApiResponse(HttpStatus.NOT_FOUND, "Attendance(s) with LessonID " + lessonId + " not found.");
        }
    }

}