package io.matoshri.learn.student;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<Object> save(@RequestBody Student newStudent) {
        var save = service.saveNewStudent(newStudent);
        return ResponseEntity.status(HttpStatus.CREATED).body(save.getId());
    }

    @GetMapping("/all")
    public ResponseEntity<Collection<Student>> getAll() { return ResponseEntity.ok(service.getAllStudents()); }

    @GetMapping
    public ResponseEntity<Object> getStudentById(@RequestParam Integer id) {
        Optional<Student> first = service.getAllStudents().stream().filter(s -> s.getId().equals(id)).findFirst();

        if (first.isPresent()) {
            return ResponseEntity.ok(first.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
