package com.example.springboot.controller;

import com.example.springboot.dao.CurriculumDao;
import com.example.springboot.dao.NoteDao;
import com.example.springboot.model.*;
import com.example.springboot.repository.AttendanceListRepository;
import com.example.springboot.repository.CurriculumRepository;
import com.example.springboot.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CurriculumController {
    private final CurriculumDao curriculumDao;
    @Autowired
    public CurriculumController(CurriculumDao curriculumDao) {
        this.curriculumDao = curriculumDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getAllCurriculums(){
        return new ApiResponse(HttpStatus.ACCEPTED, this.curriculumDao.getAllCurriculums());
    }

    @RequestMapping(value ="", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse addCurriculum(@RequestBody Curriculum newDao){
        Curriculum comment = this.curriculumDao.addCurriculum(newDao);
        return new ApiResponse(HttpStatus.ACCEPTED, comment);
    }
}
