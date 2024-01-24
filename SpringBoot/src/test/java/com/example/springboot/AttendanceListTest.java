package com.example.springboot;

import com.example.springboot.dao.AttendanceListDao;
import com.example.springboot.dao.LessonDao;
import com.example.springboot.model.AttendanceList;
import com.example.springboot.model.Exercise;
import com.example.springboot.model.Lesson;
import com.example.springboot.model.User;
import com.example.springboot.repository.AttendanceListRepository;
import com.example.springboot.repository.LessonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AttendanceListTest {
    @Mock
    private AttendanceListRepository attendanceListRepository;
    private AttendanceListDao SUT;

    @Mock
    private User user;

    @Mock
    private Exercise exercise;

    @BeforeEach
    void setup(){
        this.SUT = new AttendanceListDao(attendanceListRepository);
        AttendanceList attendanceList = new AttendanceList();
    }

    @Test
    void should_add_attendance_to_repository(){
        AttendanceList attendanceToAdd = new AttendanceList();
        Lesson lesson = new Lesson();
        User user = new User();

        lesson.setID(1);
        user.setName("TestName");

        attendanceToAdd.setID(1);
        attendanceToAdd.setLesson(lesson);
        attendanceToAdd.setUser(user);

        when(attendanceListRepository.save(attendanceToAdd)).thenReturn(attendanceToAdd);

        AttendanceList addedAttendanceList = SUT.addAttendance(attendanceToAdd);

        assertEquals(1, addedAttendanceList.getID());
        assertEquals("TestName", addedAttendanceList.getUser().getName());
        assertEquals(1, addedAttendanceList.getLesson().getID());
    }

    @Test
    void should_get_all_attendance_from_repository(){
        List<AttendanceList> expectedAttendance = new ArrayList<>();
        AttendanceList attendanceList = new AttendanceList();
        Exercise exercise = new Exercise();
        User user = new User();

        exercise.setName("TestExercise");
        user.setName("TestUser");

        attendanceList.setID(1);
        attendanceList.setExercise(exercise);
        attendanceList.setUser(user);

        expectedAttendance.add(attendanceList);

        when(attendanceListRepository.findAll()).thenReturn((expectedAttendance));
        List<AttendanceList> retrievedAttendance = SUT.getAllAttendance();

        assertEquals(expectedAttendance.size(), retrievedAttendance.size());
        assertEquals(expectedAttendance.get(0).getID(), retrievedAttendance.get(0).getID());
        assertEquals(expectedAttendance.get(0).getExercise(), retrievedAttendance.get(0).getExercise());
        assertEquals(expectedAttendance.get(0).getUser(), retrievedAttendance.get(0).getUser());
    }
}
