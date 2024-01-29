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
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AttendanceListTest {
    @Mock
    private AttendanceListRepository attendanceListRepository;
    private AttendanceListDao SUT;
    @Mock
    private AttendanceList attendanceList;
    @Mock
    private User user;

    @BeforeEach
    void setup(){
        this.SUT = new AttendanceListDao(attendanceListRepository);
        this.attendanceList = new AttendanceList();
        this.user = new User();

        user.setID(UUID.randomUUID());
        user.setName("TestUser");
        user.setUsername("TestUsername");
    }

    @Test
    void should_add_attendance_to_repository(){
        AttendanceList attendanceToAdd = new AttendanceList();
        attendanceToAdd.setID(UUID.randomUUID());
        attendanceToAdd.setUser(user);
        attendanceToAdd.setExercise(exercise);

        Lesson lesson = new Lesson();

//        lesson.setID(1);

//        attendanceList.setID(1);
        attendanceList.setLesson(lesson);
        attendanceList.setUser(user);

        when(attendanceListRepository.save(attendanceList)).thenReturn(attendanceList);

        AttendanceList addedAttendanceList = SUT.addAttendance(attendanceList);

        assertEquals(1, addedAttendanceList.getID());
        assertEquals(1, addedAttendanceList.getUser().getID());
        assertEquals("TestUser", addedAttendanceList.getUser().getName());
        assertEquals("TestUsername", addedAttendanceList.getUser().getUsername());
        assertEquals(1, addedAttendanceList.getLesson().getID());
    }

    @Test
    void should_get_all_attendance_from_repository(){
        List<AttendanceList> expectedAttendance = new ArrayList<>();
        AttendanceList attendance1 = new AttendanceList();
        attendance1.setID(UUID.randomUUID());
        attendance1.setExercise(exercise);
        attendance1.setUser(user);

        Exercise exercise = new Exercise();

        exercise.setName("TestExercise");

//        attendanceList.setID(1);
        attendanceList.setExercise(exercise);
        attendanceList.setUser(user);

        expectedAttendance.add(attendanceList);

        when(attendanceListRepository.findAll()).thenReturn((expectedAttendance));
        List<AttendanceList> retrievedAttendance = SUT.getAllAttendance();

        assertEquals(expectedAttendance.size(), retrievedAttendance.size());
        assertEquals(expectedAttendance.get(0).getID(), retrievedAttendance.get(0).getID());
        assertEquals(expectedAttendance.get(0).getExercise(), retrievedAttendance.get(0).getExercise());
        assertEquals(expectedAttendance.get(0).getUser(), retrievedAttendance.get(0).getUser());

        assertEquals(1, retrievedAttendance.get(0).getUser().getID());
        assertEquals("TestUser", retrievedAttendance.get(0).getUser().getName());
        assertEquals("TestUsername", retrievedAttendance.get(0).getUser().getUsername());
    }
}
