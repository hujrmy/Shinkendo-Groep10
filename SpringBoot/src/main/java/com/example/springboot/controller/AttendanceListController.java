package com.example.springboot.controller;


import com.example.springboot.dao.AttendanceListDao;
import com.example.springboot.model.ApiResponse;
import com.example.springboot.model.AttendanceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        return new ApiResponse(HttpStatus.OK, this.attendanceListDao.getAllAttendance());
    }

    @RequestMapping(value ="", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse addAttendance(@RequestBody AttendanceList newDao){
        AttendanceList comment = this.attendanceListDao.addAttendance(newDao);
        return new ApiResponse(HttpStatus.OK, comment);
    }


}