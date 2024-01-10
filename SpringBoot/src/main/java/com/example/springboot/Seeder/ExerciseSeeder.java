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
        for (int i = 1; i < 11; i++) {
            Exercise exercise1 = new Exercise();
            exercise1.setName("Exercise " + i);
            exercise1.setMedia("www.youtube.com/exercise" + i);
            this.exerciseDao.addExercise(exercise1);
        }
    }
}
