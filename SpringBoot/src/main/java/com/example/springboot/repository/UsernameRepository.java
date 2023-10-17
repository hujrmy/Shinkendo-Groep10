package com.example.springboot.repository;

import com.example.springboot.model.Username;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsernameRepository extends JpaRepository<Username, Integer>{

}
