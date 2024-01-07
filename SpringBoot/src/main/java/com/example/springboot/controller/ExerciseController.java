package com.example.springboot.controller;


import com.example.springboot.dao.ExerciseDao;
import com.example.springboot.model.ApiResponse;
import com.example.springboot.model.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/exercise")
public class ExerciseController {

    private final ExerciseDao exerciseDao;

    @Autowired
    public ExerciseController(ExerciseDao exerciseDao) {
        this.exerciseDao = exerciseDao;
    }


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getAllExercisesByCurriculum(long curriculumId) {
        return new ApiResponse(HttpStatus.OK, this.exerciseDao.getAllExercisesByCurriculum(curriculumId));
    }

    @RequestMapping(value ="/all", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getAllExercises() {
        return new ApiResponse(HttpStatus.OK, this.exerciseDao.getAllExercises());
    }

    @RequestMapping(value ="", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse addExercise(@RequestBody Exercise newDao){
        Exercise comment = this.exerciseDao.addExercise(newDao);
        return new ApiResponse(HttpStatus.OK, comment);
    }
}
