package com.example.springboot.controller;

import com.example.springboot.dao.*;
import com.example.springboot.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
    public ApiResponse deletePost(@PathVariable UUID postId){
        if (postDao.deletePost(postId)) {
            return new ApiResponse(HttpStatus.ACCEPTED, "Post with ID "+ postId + "has been deleted.");
        }else{
            return new ApiResponse(HttpStatus.NOT_FOUND, "Post with ID " + postId + "not found.");
        }
    }

    @RequestMapping(value ="/getHighestId", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getHighestId(){
        return new ApiResponse(HttpStatus.ACCEPTED, this.postDao.getHighestId());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Post> getProductById (@PathVariable("id") UUID id){
        Post post = postDao.findPostById(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PutMapping("/{postId}")
    @ResponseBody
    public ApiResponse<Post> updatePost(
            @PathVariable UUID postId,
            @RequestBody Post updatedPost
    ){
        Post result = postDao.updatePost(postId, updatedPost.getTitle(), updatedPost.getDescription(), updatedPost.getLink());
        if (result != null) {
            return new ApiResponse(HttpStatus.ACCEPTED, result);
        } else {
            return new ApiResponse(HttpStatus.NOT_FOUND, "User with ID " + postId + " not found.");
        }
    }
}
