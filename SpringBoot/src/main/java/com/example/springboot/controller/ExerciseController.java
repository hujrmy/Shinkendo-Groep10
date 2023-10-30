package com.example.springboot.controller;


import com.example.springboot.dao.ExerciseDao;
import com.example.springboot.model.ApiResponse;
import com.example.springboot.model.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/exercise")
public class ExerciseController {

    private final ExerciseDao exerciseDao;

    @Autowired
    public ExerciseController(ExerciseDao exerciseDao) {
        this.exerciseDao = exerciseDao;
    }

    @RequestMapping(value = "media", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getMediaByCurriculumId(@RequestParam("curriculumId") int curriculumId) {
        Exercise exerciseMedia = this.exerciseDao.getExerciseMediaByCurriculumId(curriculumId);
        return new ApiResponse(HttpStatus.ACCEPTED, exerciseMedia);
    }
    @RequestMapping(value = "names", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getExercisesByCurriculumId(@RequestParam("curriculumId") int curriculumId) {
        Exercise exerciseNames = this.exerciseDao.getExerciseNamesByCurriculumId(curriculumId);
        return new ApiResponse(HttpStatus.ACCEPTED, exerciseNames);
    }

    @RequestMapping(value ="", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse addExercise(@RequestBody Exercise newDao){
        Exercise comment = this.exerciseDao.addExercise(newDao);
        return new ApiResponse(HttpStatus.ACCEPTED, comment);
    }
}
