package com.example.springboot.controller;

import com.example.springboot.dao.LessonDao;
import com.example.springboot.model.ApiResponse;
import com.example.springboot.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/lesson")
public class LessonController {
    private final LessonDao lessonDao;

    @Autowired
    public LessonController(LessonDao lessonDao) {
        this.lessonDao = lessonDao;
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getAllLessons(){
        return new ApiResponse(HttpStatus.ACCEPTED, this.lessonDao.getAllLessons());
    }


    @RequestMapping(value ="/{lessonId}", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getLessonById(@PathVariable long lessonId) {
        return new ApiResponse(HttpStatus.ACCEPTED, this.lessonDao.getLessonById(lessonId));
    }

    @RequestMapping(value ="", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse addLesson(@RequestBody Lesson newDao){
        Lesson comment = this.lessonDao.addLesson(newDao);
        return new ApiResponse(HttpStatus.ACCEPTED, comment);
    }

    @DeleteMapping("/delete/{lessonId}")
    @ResponseBody
    public ApiResponse deleteLesson(@PathVariable long lessonId) {
        if (lessonDao.deleteLesson(lessonId)) {
            return new ApiResponse(HttpStatus.ACCEPTED, "Lesson with ID " + lessonId + " has been deleted.");
        } else {
            return new ApiResponse(HttpStatus.NOT_FOUND, "Lesson with ID " + lessonId + " not found.");
        }
    }
}
