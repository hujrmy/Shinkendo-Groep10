package com.example.springboot.Seeder;

import com.example.springboot.dao.*;
import com.example.springboot.model.*;
import com.github.javafaker.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.cglib.core.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.*;

@Component
public class UserExercisesSeeder {

    @Autowired
    private UserExercisesDao userExercisesDao;

    public void seed(User user, Faker faker){
        for (int j = 0; j < 10; j++) {
            Date date = faker.date().birthday(0,1);
            UserExercises userExercises = new UserExercises();
            userExercises.setExerciseToDo(10);
            userExercises.setExerciseDone(0);
            userExercises.setLastDone(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            this.userExercisesDao.addUserExercises(userExercises);
        }
    }
}
