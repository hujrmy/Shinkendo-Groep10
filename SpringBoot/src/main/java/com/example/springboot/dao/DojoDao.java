package com.example.springboot.dao;

import com.example.springboot.model.Dojo;
import com.example.springboot.repository.DojoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DojoDao {

    @Autowired
    private DojoRepository dojoRepository;


    public Dojo addDojo(Dojo newDojo) {
        Dojo dojo = this.dojoRepository.save(newDojo);
        return dojo;
    }

    public ArrayList<Dojo> getAllDojo(){
        ArrayList<Dojo> allDojo = (ArrayList<Dojo>) this.dojoRepository.findAll();
        return allDojo;
    }
}
