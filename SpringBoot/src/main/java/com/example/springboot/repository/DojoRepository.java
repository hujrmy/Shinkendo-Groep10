package com.example.springboot.repository;

import com.example.springboot.model.Dojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DojoRepository extends JpaRepository<Dojo, UUID>{
}
