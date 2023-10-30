package com.example.springboot.Seeder;

import com.example.springboot.dao.CurriculumDao;
import com.example.springboot.model.Curriculum;
import com.github.javafaker.Faker;
import com.example.springboot.model.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurriculumSeeder {

    @Autowired
    private CurriculumDao curriculumDao;

    public void seed(Faker faker){
        for (int i = 0; i < 200; i++) {
            Curriculum curriculum1 = new Curriculum();
            curriculum1.setName(String.valueOf(faker.name()));
            curriculum1.setDescription(String.join(" ", faker.lorem().characters(20)));
            this.curriculumDao.addCurriculum(curriculum1);

            Curriculum curriculum2 = new Curriculum();
            curriculum1.setName(String.valueOf(faker.name()));
            curriculum2.setDescription(String.join(" ", faker.lorem().characters(20)));
            this.curriculumDao.addCurriculum(curriculum2);
        }
    }
}
