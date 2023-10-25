package com.example.springboot.repository;

import com.example.springboot.model.Dojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DojoRepository extends JpaRepository<Dojo, Integer>{

}
