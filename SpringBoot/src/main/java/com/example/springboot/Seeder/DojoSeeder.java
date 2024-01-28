package com.example.springboot.Seeder;

import com.example.springboot.dao.DojoDao;
import com.example.springboot.model.Dojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DojoSeeder {
    @Autowired
    private DojoDao dojoDao;

    public Dojo seed(){
        Dojo dojo = new Dojo();
        dojo.setName("Shinkendo");
        dojo.setID(UUID.randomUUID());
        dojo.setPlace("Amsterdam");
        this.dojoDao.addDojo(dojo);
        return dojo;
    }
}
