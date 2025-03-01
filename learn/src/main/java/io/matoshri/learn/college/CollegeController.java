package io.matoshri.learn.college;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/college")
public class CollegeController {

    private final CollegeService service;

    public CollegeController(CollegeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody College college) {
        log.info("Saving College {}", college);
        final Integer id = service.save(college).getId();
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @GetMapping
    public ResponseEntity<Collection<College>> getAll() {
        log.info("Fetching all college");
        final Collection<College> colleges = Collections.unmodifiableCollection(service.getAll());
        return ResponseEntity.ok(colleges);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCollegeById(@PathVariable(name = "id") Integer id) {
        log.info("Fetching College by ID {}", id);
        final var collge = service.getCollege(id);
        return ResponseEntity.ok(collge);
    }

    @GetMapping("/{page}/{size}")
    public Collection<College> getAll(@PathVariable Integer page,
                                      @PathVariable Integer size) {
        page = Optional.ofNullable(page).orElse(0);
        size = Optional.ofNullable(size).orElse(10);
        log.info("Fetching COllege page {} size {}", page, size);
        final var list = Collections.unmodifiableCollection(service.getAll(page, size).toList());
        return list;
    }
}
