package com.example.springboot.Seeder;

import com.example.springboot.dao.DojoDao;
import com.example.springboot.model.Dojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DojoSeeder {
    @Autowired
    private DojoDao dojoDao;

    public void seed(){
        for (int i = 0; i < 8; i++) {
            Dojo dojo = new Dojo();
            dojo.setName("Shinkendo");
            dojo.setID(1);
            dojo.setPlace("Amsterdam");
            this.dojoDao.addDojo(dojo);
        }
    }
}
