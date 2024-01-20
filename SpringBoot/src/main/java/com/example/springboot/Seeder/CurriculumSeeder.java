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
        List<String> ranks = List.of(new String[]{"Ichimonji", "Jiho", "Santen", "Shiho", "Kirigami", "Gohou", "Gohoumokuroku", "Hyaku-e"});
        for(int i = 0; i < 8; i++) {
            Curriculum rank = new Curriculum();
            rank.setName(ranks.get(i));
            rank.setDescription("rank" + i+1);
            this.curriculumDao.addCurriculum(rank);
        }
    }
}
