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

    @GetMapping("/all")
    public Collection<College> getAll() { return service.getAll(); }

    @GetMapping
    public College getCollegeById(@RequestParam(name = "id") Integer id) {
        return service.getCollege(id);
    }
}
