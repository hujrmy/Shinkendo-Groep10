package com.example.springboot.repository;

import com.example.springboot.model.Dojo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DojoRepository extends JpaRepository<Dojo, Integer>{

}
