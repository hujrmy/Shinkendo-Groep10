package com.example.springboot.controller;

import com.example.springboot.dao.DojoDao;
import com.example.springboot.model.ApiResponse;
import com.example.springboot.model.Dojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/dojo")
public class DojoController {

    private final DojoDao dojoDao;

    @Autowired
    public DojoController(DojoDao dojoDao) {
        this.dojoDao = dojoDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getAllDojo(){
        return new ApiResponse(HttpStatus.OK, this.dojoDao.getAllDojo());
    }

    @RequestMapping(value ="", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse addDojo(@RequestBody Dojo newDao){
        Dojo comment = this.dojoDao.addDojo(newDao);
        return new ApiResponse(HttpStatus.OK, comment);
    }

}
