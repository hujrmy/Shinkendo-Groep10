package com.example.springboot.dao;

import com.example.springboot.model.*;
import com.example.springboot.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class PostDao {

    @Autowired
    private PostRepository postRepository;

    public PostDao(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post addPost(Post newPost){
        Post post = this.postRepository.save(newPost);
        return post;
    }

    public ArrayList<Post> getAllPost(){
        ArrayList<Post> posts = (ArrayList<Post>) this.postRepository.findAll();
        return posts;
    }

    public boolean deletePost(long postId){
        if(postRepository.existsById((int) postId)) {
            postRepository.deleteById((int) postId);
            return true;
        }
        return false;
    }

    public Long getHighestId(){
        return postRepository.getHighestId();
    }
}
