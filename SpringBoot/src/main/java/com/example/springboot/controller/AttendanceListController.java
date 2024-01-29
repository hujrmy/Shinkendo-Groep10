package com.example.springboot.controller;


import com.example.springboot.dao.AttendanceListDao;
import com.example.springboot.dao.UserDao;
import com.example.springboot.model.ApiResponse;
import com.example.springboot.model.AttendanceList;
import com.example.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/attendanceList")
public class AttendanceListController {

    private final AttendanceListDao attendanceListDao;
    private final UserDao userDao;


    @Autowired
    public AttendanceListController(AttendanceListDao attendanceListDao, UserDao userDao) {
        this.attendanceListDao = attendanceListDao;
        this.userDao = userDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getAllAttendance(){
        return new ApiResponse(HttpStatus.ACCEPTED, this.attendanceListDao.getAllAttendance());
    }

    @RequestMapping(value ="/lesson/{lessonId}", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getAttendanceByLesson(@PathVariable long lessonId) {
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

    @PutMapping("/{attendanceId}")
    @ResponseBody
    public ApiResponse<AttendanceList> updateAttendance(
            @PathVariable long attendanceId,
            @RequestBody AttendanceList updatedAttendance
    ){
        System.out.println("test");
        User newUser = userDao.findUserById(updatedAttendance.getUser().getID());
        System.out.println("test" + newUser);
        AttendanceList result = attendanceListDao.updateAttendance(attendanceId, newUser, updatedAttendance.getExercise(), updatedAttendance.getLesson());
        if (result != null) {
            return new ApiResponse(HttpStatus.ACCEPTED, result);
        } else {
            return new ApiResponse(HttpStatus.NOT_FOUND, "Attendance with ID " + attendanceId + " not found.");
        }
    }

}