package io.matoshri.learn.student;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Student newStudent) {
        log.info("Saving student {}", newStudent);
        var save = service.saveNewStudent(newStudent);
        return ResponseEntity.status(HttpStatus.CREATED).body(save.getId());
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> getAll() {
        log.info("Fetching all students");
        Collection<Student> students = Collections.unmodifiableCollection(service.getAllStudents());
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getStudentById(@PathVariable Integer id) {
        log.info("Fetching student by ID {}", id);
        Optional<Student> first = service.getAllStudents().stream().filter(s -> s.getId().equals(id)).findFirst();

        if (first.isPresent()) {
            return ResponseEntity.ok(first.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{page}/{size}")
    public Collection<Student> getAll(@PathVariable Integer page,
                                      @PathVariable Integer size) {
        page = Optional.ofNullable(page).orElse(0);
        size = Optional.ofNullable(size).orElse(10);
        log.info("Fetching student page no {} size {}", page, size);
        Collection<Student> students = Collections.unmodifiableCollection(service.getAllStudents(page, size).toList());
        return students;
    }
}
