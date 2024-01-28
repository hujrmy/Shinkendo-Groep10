package com.example.springboot.controller;

import com.example.springboot.dao.CurriculumDao;
import com.example.springboot.model.ApiResponse;
import com.example.springboot.model.Curriculum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/curriculum")
public class CurriculumController {
    private final CurriculumDao curriculumDao;
    @Autowired
    public CurriculumController(CurriculumDao curriculumDao) {
        this.curriculumDao = curriculumDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getAllCurriculums() {
        List<Curriculum> curriculums = curriculumDao.getAllCurriculumsOrderedById();
        return new ApiResponse(HttpStatus.ACCEPTED, curriculums);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse addCurriculum(@RequestBody Curriculum newDao){
        Curriculum comment = this.curriculumDao.addCurriculum(newDao);
        return new ApiResponse(HttpStatus.ACCEPTED, comment);
    }

    @DeleteMapping("/{curriculumId}")
    @ResponseBody
    public ApiResponse deleteCurriculum(@PathVariable UUID curriculumId) {
        if (curriculumDao.deleteCurriculum(curriculumId)) {
            return new ApiResponse(HttpStatus.ACCEPTED, "Curriculum with ID " + curriculumId + " has been deleted.");
        } else {
            return new ApiResponse(HttpStatus.NOT_FOUND, "Curriculum with ID " + curriculumId + " not found.");
        }
    }

    @PutMapping("/{curriculumId}")
    @ResponseBody
    public ApiResponse updateCurriculum(
            @PathVariable UUID curriculumId,
            @RequestBody Curriculum updatedCurriculum) {
        Curriculum result = curriculumDao.updateCurriculum(curriculumId, updatedCurriculum.getName(), updatedCurriculum.getDescription());
        if (result != null) {
            return new ApiResponse(HttpStatus.ACCEPTED, result);
        } else {
            return new ApiResponse(HttpStatus.NOT_FOUND, "Curriculum with ID " + curriculumId + " not found.");
        }
    }


}
