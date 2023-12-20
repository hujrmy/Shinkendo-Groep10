package com.example.springboot.controller;

import com.example.springboot.dao.UserExercisesDao;
import com.example.springboot.model.ApiResponse;
import com.example.springboot.model.Post;
import com.example.springboot.model.UserExercises;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/userExercises")
public class UserExercisesController {
    private final UserExercisesDao userExercisesDao;

    @Autowired
    public UserExercisesController(UserExercisesDao userExercisesDao) {
        this.userExercisesDao = userExercisesDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getUserExercises(){
        return new ApiResponse(HttpStatus.ACCEPTED, this.userExercisesDao.getAllUserExercises());
    }

    @RequestMapping(value ="", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse addUserExercises(@RequestBody UserExercises newDao){
        UserExercises add = this.userExercisesDao.addUserExercises(newDao);
        return new ApiResponse(HttpStatus.ACCEPTED, add);
    }

    @DeleteMapping("/{postId}")
    @ResponseBody
    public ApiResponse deleteUserExercises(@PathVariable long userExercisesId) {
        if (userExercisesDao.deleteUserExercises(userExercisesId)) {
            return new ApiResponse(HttpStatus.ACCEPTED, "Post with ID " + userExercisesId + "has been deleted.");
        } else {
            return new ApiResponse(HttpStatus.NOT_FOUND, "Post with ID " + userExercisesId + "not found.");
        }
    }
}
