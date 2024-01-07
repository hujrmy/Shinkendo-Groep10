package com.example.springboot.Seeder;


import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class DatabaseSeeder {

    @Autowired
    private CurriculumSeeder curriculumSeeder;
    @Autowired
    private ExerciseSeeder exerciseSeeder;
    @Autowired
    private DojoSeeder dojoSeeder;
    private boolean alreadySeeded = false;


    @EventListener
    public void seed(ContextRefreshedEvent event){
        if(alreadySeeded){
            return;
        }

        Faker faker = new Faker(new Locale("nl"));
        curriculumSeeder.seed(faker);
        exerciseSeeder.seed(faker);
        dojoSeeder.seed();


        this.alreadySeeded = true;
    }
}
