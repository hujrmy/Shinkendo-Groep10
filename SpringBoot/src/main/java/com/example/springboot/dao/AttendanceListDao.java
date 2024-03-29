package com.example.springboot.dao;

import com.example.springboot.Exception.ExercisesNotFoundException;
import com.example.springboot.model.*;
import com.example.springboot.repository.AttendanceListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AttendanceListDao {

    @Autowired
    private AttendanceListRepository attendanceListRepository;

    public AttendanceList addAttendance(AttendanceList newattendanceList) {
        AttendanceList attendanceList = this.attendanceListRepository.save(newattendanceList);
        return attendanceList;
    }

    public ArrayList<AttendanceList> getAllAttendance(){
        ArrayList<AttendanceList> attendanceLists = (ArrayList<AttendanceList>) this.attendanceListRepository.findAll();
        return attendanceLists;
    }

    public List<AttendanceList> getAttendancesByLessonId(UUID lessonId) {
        ArrayList<AttendanceList> attendanceLists = new ArrayList<>();
        List<AttendanceList> attendances = this.attendanceListRepository.findAll();

        for (AttendanceList attendance : attendances) {
            if(Objects.equals(attendance.getLesson().getID(), lessonId)){
                attendanceLists.add(attendance);
            }
        }
        return attendanceLists;
    }

    public AttendanceListDao(AttendanceListRepository attendanceListRepository){
        this.attendanceListRepository = attendanceListRepository;
    }

    public boolean deleteAttendanceByLesson(UUID lessonId) {
        ArrayList<AttendanceList> attendancesToDelete = new ArrayList<>();
        List<AttendanceList> attendances = this.attendanceListRepository.findAll();

        for (AttendanceList attendance : attendances) {
            if(Objects.equals(attendance.getLesson().getID(), lessonId)){
                attendancesToDelete.add(attendance);
            }
        }

        if (attendancesToDelete.isEmpty()) {
            return false;
        }

        for (AttendanceList attendance : attendancesToDelete) {
            if (attendanceListRepository.existsById(attendance.getID())) {
                attendanceListRepository.deleteById(attendance.getID());
                System.out.println("testing: " + attendance);
            }
        }

        return true;
    }

    public AttendanceList updateAttendance(UUID attendanceId, User newUser, Exercise newExercise, Lesson newLesson) {
        Optional<AttendanceList> attendanceListOptional = attendanceListRepository.findById(attendanceId);
        if (attendanceListOptional.isPresent()) {
            AttendanceList attendanceList = attendanceListOptional.get();
            attendanceList.setUser(newUser);
            attendanceList.setExercise(newExercise);
            attendanceList.setLesson(newLesson);
            attendanceList = attendanceListRepository.save(attendanceList);
            return attendanceList;
        }
        return null;
    }

}
