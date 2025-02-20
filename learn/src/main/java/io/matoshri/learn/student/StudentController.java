package io.matoshri.learn.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    StudentService service;

    @PostMapping("/new")
    public Object save(@RequestBody Student newStudent) {
        var save = service.saveNewStudent(newStudent);
        return save.getId();
    }

    @GetMapping
    public Collection<Student> getAll() { return service.getAllStudents(); }
}
