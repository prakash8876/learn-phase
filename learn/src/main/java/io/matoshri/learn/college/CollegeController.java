package io.matoshri.learn.college;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/college")
public class CollegeController {

    private final CollegeService service;

    @Autowired
    public CollegeController(CollegeService service) {
        this.service = service;
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Object> save(@RequestBody College college) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(college).getId());
    }

    @GetMapping("/all")
    public ResponseEntity<Collection<College>> getAll() { return ResponseEntity.ok(service.getAll()); }

    @GetMapping
    public ResponseEntity<Object> getCollegeById(@RequestParam(name = "id") Integer id) {
        return ResponseEntity.ok(service.getCollege(id));
    }
}
