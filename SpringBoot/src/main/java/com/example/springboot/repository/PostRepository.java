package com.example.springboot.repository;

import com.example.springboot.model.*;
import org.springframework.data.jpa.repository.*;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
