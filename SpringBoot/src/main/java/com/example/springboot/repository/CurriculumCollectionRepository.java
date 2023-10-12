//package com.example.springboot.repository;
//
//import jakarta.annotation.PostConstruct;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class CurriculumCollectionRepository {
//    private final List<Curriculum> curriculum = new ArrayList<>();
//
//    public CurriculumCollectionRepository() {
//    }
//
//    public List<Curriculum> findAll(){
//        return curriculum;
//    }
//
//    public Optional<Curriculum> findByName(String name){
//        return curriculum.stream().filter(c -> c.name().equals(name)).findFirst();
//    }
//
//    @PostConstruct
//    private void init(){
//        Curriculum c = new Curriculum("Curriculum1", "dit bevat het volgende:");
//        curriculum.add(c);
//    }
//}
