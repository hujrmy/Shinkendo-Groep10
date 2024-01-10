package com.example.springboot.controller;


import com.example.springboot.dao.ExerciseDao;
import com.example.springboot.model.ApiResponse;
import com.example.springboot.model.Exercise;
import com.example.springboot.model.User;
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


    @RequestMapping(value ="/all", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getAllExercises() {
        return new ApiResponse(HttpStatus.OK, this.exerciseDao.getAllExercises());
    }

    @RequestMapping(value ="/{exerciseId}", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getExerciseById(@PathVariable long exerciseId) {
        return new ApiResponse(HttpStatus.ACCEPTED, this.exerciseDao.getExerciseById(exerciseId));
    }

    @RequestMapping(value ="", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse addExercise(@RequestBody Exercise newDao){
        Exercise comment = this.exerciseDao.addExercise(newDao);
        return new ApiResponse(HttpStatus.OK, comment);
    }

    @DeleteMapping("/{exerciseId}")
    @ResponseBody
    public ApiResponse deleteExercise(@PathVariable long exerciseId) {
        if (exerciseDao.deleteExercise(exerciseId)) {
            return new ApiResponse(HttpStatus.ACCEPTED, "Exercise with ID " + exerciseId + " has been deleted.");
        } else {
            return new ApiResponse(HttpStatus.NOT_FOUND, "Exercise with ID " + exerciseId + " not found.");
        }
    }

    @PutMapping("/{exerciseId}")
    @ResponseBody
    public ApiResponse<Exercise> updateExercise(
            @PathVariable long exerciseId,
            @RequestBody Exercise updatedExercise
    ){
        Exercise result = exerciseDao.updateExercise(exerciseId, updatedExercise.getName(), updatedExercise.getMedia());
        if (result != null) {
            return new ApiResponse(HttpStatus.ACCEPTED, result);
        } else {
            return new ApiResponse(HttpStatus.NOT_FOUND, "User with ID " + exerciseId + " not found.");
        }
    }
}
