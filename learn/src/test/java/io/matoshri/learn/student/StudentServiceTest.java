package io.matoshri.learn.student;

import io.matoshri.learn.address.Address;
import io.matoshri.learn.college.College;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    StudentService studentService;

    @Test
    void saveNewStudent() {
        Student s = new Student("Test","test@email.com","1st",new College("College1", new Address(), List.of()), new Address());
        assertNotNull(studentService.saveNewStudent(s));
    }

    @Test
    void getAllStudents() {
        List<Student> allStudents = studentService.getAllStudents();
        assertNotNull(allStudents);
    }
}