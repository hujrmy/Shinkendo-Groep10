package com.example.springboot.dao;

import com.example.springboot.model.*;
import com.example.springboot.model.User;
import com.example.springboot.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

import java.time.*;
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

    public boolean deletePost(UUID postId){
        if(postRepository.existsById(postId)) {
            postRepository.deleteById(postId);
            return true;
        }
        return false;
    }

    public Long getHighestId(){
        return postRepository.getHighestId();
    }

    public Post findPostById(UUID id) {
        return postRepository.findPostByID(id).orElseThrow(() -> new UsernameNotFoundException("Post not found"));
    }

    public Post updatePost(UUID postId, String title, String description, String link) {
        Optional<Post> postOptional = postRepository.findPostByID(postId);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            post.setTitle(title);
            post.setDescription(description);
            post.setLink(link);
            post.setDate(LocalDate.now());
            post = postRepository.save(post);
            return post;
        }
        return null;
    }
}
