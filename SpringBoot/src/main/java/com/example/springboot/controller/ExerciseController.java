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

//    @RequestMapping(value = "media", method = RequestMethod.GET)
//    @ResponseBody
//    public ApiResponse getMediaByCurriculumId(@RequestParam("curriculumId") long curriculumId) {
//        List<String> exerciseMedia = this.exerciseDao.getExerciseMediaByCurriculumId(curriculumId);
//        return new ApiResponse(HttpStatus.ACCEPTED, exerciseMedia);     }
//    @RequestMapping(value = "names", method = RequestMethod.GET)
//    @ResponseBody
//    public ApiResponse getExercisesByCurriculumId(@RequestParam("curriculumId") long curriculumId) {
//        List<String> exerciseNames = this.exerciseDao.getExerciseNamesByCurriculumId(curriculumId);
//        return new ApiResponse(HttpStatus.ACCEPTED, exerciseNames);
//    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getAllExercisesByCurriculum(long curriculumId) {
        return new ApiResponse(HttpStatus.ACCEPTED, this.exerciseDao.getAllExercisesByCurriculum(curriculumId));
    }

    @RequestMapping(value ="/all", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getAllExercises() {
        return new ApiResponse(HttpStatus.ACCEPTED, this.exerciseDao.getAllExercises());
    }

    @RequestMapping(value ="", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse addExercise(@RequestBody Exercise newDao){
        Exercise comment = this.exerciseDao.addExercise(newDao);
        return new ApiResponse(HttpStatus.ACCEPTED, comment);
    }
}
