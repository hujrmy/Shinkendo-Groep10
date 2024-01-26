package com.example.springboot.repository;

import com.example.springboot.model.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query("SELECT MAX(ID) FROM Post")
    Long getHighestId();

    Optional<Post> findPostByID(Long id);

}
