package com.example.springboot.repository;

import com.example.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsernameRepository extends JpaRepository<User, Integer>{

}
