package com.example.springboot.controller;

import com.example.springboot.dao.UserDao;
import com.example.springboot.model.ApiResponse;
import com.example.springboot.model.Curriculum;
import com.example.springboot.model.Rights;
import com.example.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserDao userDao;
    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping(value = "allNames", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getAllNames(){
        List<String> allNames = this.userDao.getAllUserData();
        return new ApiResponse(HttpStatus.OK, allNames);
    }

    @RequestMapping(value = "names", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getUsersByName(@RequestParam("name") String name) {
        List<String> names = this.userDao.getUsersByName(name);
        return new ApiResponse(HttpStatus.OK, names);
    }

    @RequestMapping(value = "rights", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getRightsByName(@RequestParam("username") String username) {
        List<Rights> rights = this.userDao.getRightsByUserName(username);
        return new ApiResponse(HttpStatus.OK, rights);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getAllUsers() {
        return new ApiResponse(HttpStatus.OK, this.userDao.getAllUsers());
    }

    @RequestMapping(value ="", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse addUsers(@RequestBody User newDao){
        User add = this.userDao.addUsers(newDao);
        return new ApiResponse(HttpStatus.OK, add);
    }
}
