package com.example.springboot.controller;

import com.example.springboot.dao.CurriculumExercisesDao;
import com.example.springboot.model.ApiResponse;
import com.example.springboot.model.CurriculumExercises;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/curriculumExercises")
public class CurriculumExercisesController {
    private final CurriculumExercisesDao curriculumExercisesDao;

    @Autowired
    public CurriculumExercisesController(CurriculumExercisesDao curriculumExercisesDao) {
        this.curriculumExercisesDao = curriculumExercisesDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getUserExercises(){
        return new ApiResponse(HttpStatus.ACCEPTED, this.curriculumExercisesDao.getAllCurriculumExercises());
    }

    @RequestMapping(value ="", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse addUserExercises(@RequestBody CurriculumExercises newDao){
        CurriculumExercises add = this.curriculumExercisesDao.addCurriculumExercises(newDao);
        return new ApiResponse(HttpStatus.ACCEPTED, add);
    }

    @DeleteMapping("/{curriculumExercisesId}")
    @ResponseBody
    public ApiResponse deleteUserExercises(@PathVariable long curriculumExercisesId) {
        if (curriculumExercisesDao.deleteCurriculumExercisesByExerciseId(curriculumExercisesId)) {
            return new ApiResponse(HttpStatus.ACCEPTED, "Exercise with ID " + curriculumExercisesId + "has been deleted.");
        } else {
            return new ApiResponse(HttpStatus.NOT_FOUND, "Exercise with ID " + curriculumExercisesId + "not found.");
        }
    }
}
