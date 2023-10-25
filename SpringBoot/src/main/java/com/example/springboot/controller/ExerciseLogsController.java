package com.example.springboot.controller;

import com.example.springboot.dao.ExerciseLogsDao;
import com.example.springboot.model.ApiResponse;
import com.example.springboot.model.ExerciseLogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exercise_logs")
public class ExerciseLogsController {
    private final ExerciseLogsDao exerciseLogsDao;
    @Autowired
    public ExerciseLogsController(ExerciseLogsDao exerciseLogsDao) {
        this.exerciseLogsDao = exerciseLogsDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getAllExerciseLogs(){
        return new ApiResponse(HttpStatus.ACCEPTED, this.exerciseLogsDao.getAllExerciseLogs());
    }

    @RequestMapping(value ="", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse addExerciseLogs(@RequestBody ExerciseLogs newDao){
        ExerciseLogs comment = this.exerciseLogsDao.addExerciseLogs(newDao);
        return new ApiResponse(HttpStatus.ACCEPTED, comment);
    }
}
