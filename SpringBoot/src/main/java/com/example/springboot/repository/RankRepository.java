package com.example.springboot.repository;

import com.example.springboot.model.Rank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankRepository extends JpaRepository<Rank, Integer>{

}
