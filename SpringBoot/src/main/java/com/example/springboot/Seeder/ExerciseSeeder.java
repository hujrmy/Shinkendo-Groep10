package com.example.springboot.Seeder;

import com.example.springboot.dao.ExerciseDao;
import com.example.springboot.model.Exercise;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ExerciseSeeder {
    @Autowired
    private ExerciseDao exerciseDao;
    public void seed(Faker faker){
        for (int i = 0; i < 10; i++) {
            Exercise exercise1 = new Exercise();
            exercise1.setName(String.valueOf(faker.name()));
            exercise1.setMedia(String.join(" ", faker.lorem().characters(20)));
            this.exerciseDao.addExercise(exercise1);
        }
    }
}
