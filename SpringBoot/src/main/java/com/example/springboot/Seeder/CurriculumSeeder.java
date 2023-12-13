package com.example.springboot.Seeder;

import com.example.springboot.dao.CurriculumDao;
import com.example.springboot.model.Curriculum;
import com.github.javafaker.Faker;
import com.example.springboot.model.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CurriculumSeeder {

    @Autowired
    private CurriculumDao curriculumDao;

    public void seed(){
        for(int i = 0; i < 8; i++) {
            Curriculum rank1 = new Curriculum();
            List<String> ranks = List.of(new String[]{"Ikkyu", "Nikyu", "Sankyu", "Yonkyu", "Gokyu", "Roklyu", "Nanakyu", "Hachikyu"});
            rank1.setName(ranks.get(i));
            rank1.setDescription("rank" + i+1);
            this.curriculumDao.addCurriculum(rank1);
        }
    }
}
