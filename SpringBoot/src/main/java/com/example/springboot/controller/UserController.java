package com.example.springboot.controller;

import com.example.springboot.dao.UserDao;
import com.example.springboot.model.ApiResponse;
import com.example.springboot.model.Enums.Rights;
import com.example.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
        return new ApiResponse(HttpStatus.ACCEPTED, allNames);
    }

    @RequestMapping(value = "names", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getUsersByName(@RequestParam("name") String name) {
        List<String> names = this.userDao.getUsersByName(name);
        return new ApiResponse(HttpStatus.ACCEPTED, names);
    }

    @RequestMapping(value = "rights", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getRightsByName(@RequestParam("username") String username) {
        List<Rights> rights = this.userDao.getRightsByUserName(username);
        return new ApiResponse(HttpStatus.ACCEPTED, rights);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getAllUsers() {
        return new ApiResponse(HttpStatus.ACCEPTED, this.userDao.getAllUsers());
    }

    @RequestMapping(value ="", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse addUsers(@RequestBody User newDao){
        User add = this.userDao.addUsers(newDao);
        return new ApiResponse(HttpStatus.ACCEPTED, add);
    }

    @DeleteMapping("/{userId}")
    @ResponseBody
    public ApiResponse deleteUser(@PathVariable UUID userId) {
        if (userDao.deleteUser(userId)) {
            return new ApiResponse(HttpStatus.ACCEPTED, "Curriculum with ID " + userId + " has been deleted.");
        } else {
            return new ApiResponse(HttpStatus.NOT_FOUND, "Curriculum with ID " + userId + " not found.");
        }
    }

    @PutMapping("/{userId}")
    @ResponseBody
    public ApiResponse<User> updateUser(
            @PathVariable UUID userId,
            @RequestBody User updatedUser
    ){
        User result = userDao.updateUser(userId, updatedUser.getRights(), updatedUser.getName(), updatedUser.getUsername(), updatedUser.getPassword(),
                updatedUser.getDojo(), updatedUser.getRank());
        if (result != null) {
            return new ApiResponse(HttpStatus.ACCEPTED, result);
        } else {
            return new ApiResponse(HttpStatus.NOT_FOUND, "User with ID " + userId + " not found.");
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getProductById (@PathVariable("id") UUID id){
        User user = userDao.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
