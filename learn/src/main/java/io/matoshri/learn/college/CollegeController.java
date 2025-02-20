package io.matoshri.learn.college;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/college")
public class CollegeController {

    private final CollegeService service;

    public CollegeController(CollegeService service) {
        this.service = service;
    }

    @PostMapping(value = "/new")
    public Object save(@RequestBody College college) {
        return service.save(college).getId();
    }

    @GetMapping
    public Collection<College> getAll() { return service.getAll(); }
}
