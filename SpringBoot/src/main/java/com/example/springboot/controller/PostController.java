package com.example.springboot.controller;

import com.example.springboot.dao.*;
import com.example.springboot.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {
    private final PostDao postDao;

    @Autowired
    public PostController(PostDao postDao) {
        this.postDao = postDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getPosts(){
        return new ApiResponse(HttpStatus.ACCEPTED, this.postDao.getAllPost());
    }

    @RequestMapping(value ="", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse addUsers(@RequestBody Post newDao){
        Post add = this.postDao.addPost(newDao);
        return new ApiResponse(HttpStatus.ACCEPTED, add);
    }

    @DeleteMapping("/{postId}")
    @ResponseBody
    public ApiResponse deletePost(@PathVariable long postId){
        if (postDao.deletePost(postId)) {
            return new ApiResponse(HttpStatus.ACCEPTED, "Post with ID "+ postId + "has been deleted.");
        }else{
            return new ApiResponse(HttpStatus.NOT_FOUND, "Post with ID " + postId + "not found.");
        }
    }
}
