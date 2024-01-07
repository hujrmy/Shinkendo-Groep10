package com.example.springboot.controller;

import com.example.springboot.dao.NoteDao;
import com.example.springboot.model.ApiResponse;
import com.example.springboot.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/note")
public class NoteController {
    private final NoteDao noteDao;

    @Autowired
    public NoteController(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getAllNotes(){
        return new ApiResponse(HttpStatus.OK, this.noteDao.getAllNotes());
    }

    @RequestMapping(value ="", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse addNote(@RequestBody Note newDao){
        Note comment = this.noteDao.addNote(newDao);
        return new ApiResponse(HttpStatus.OK, comment);
    }
}
