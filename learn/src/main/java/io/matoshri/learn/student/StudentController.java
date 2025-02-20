package io.matoshri.learn.student;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public Object save(@RequestBody Student newStudent) {
        var save = service.saveNewStudent(newStudent);
        return save.getId();
    }

    @GetMapping
    public Collection<Student> getAll() { return service.getAllStudents(); }

    @GetMapping
    public Student getStudentById(@RequestParam Integer id) {
        return service.getAllStudents().stream().filter(s -> s.getId().equals(id)).findFirst()
                .orElse(null);
    }
}
