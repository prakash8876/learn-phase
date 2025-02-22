package io.matoshri.learn.college;

import io.matoshri.learn.address.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CollegeServiceTest {

    @Autowired
    CollegeService collegeService;

    @Test
    void save() {
        College c = new College();
        c.setCollegeName("Test");
        c.setAddress(new Address());
        c.setStudents(List.of());

        College saved = collegeService.save(c);
        assertNotNull(saved);
    }

    @Test
    void getAll() {
        List<College> all = collegeService.getAll();
        assertNotNull(all);
    }

    @Test
    void isCollegeExistsById() {
        boolean collegeExistsById = collegeService.isCollegeExistsById(1);
        assertTrue(collegeExistsById);
    }

    @Test
    void getCollege() {
        College college = collegeService.getCollege(1);
        assertNotNull(college);
    }

    @Test
    void findCollege() {
        Optional<College> test = collegeService.findCollege("KIDZEE");
        assertTrue(test.isPresent());
    }
}