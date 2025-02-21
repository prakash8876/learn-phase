package io.matoshri.learn.student;

import com.google.gson.Gson;
import io.matoshri.learn.address.Address;
import io.matoshri.learn.address.AddressService;
import io.matoshri.learn.college.College;
import io.matoshri.learn.college.CollegeService;
import io.matoshri.learn.exception.StudentException;
import io.matoshri.learn.kafka.Producer;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class StudentService {

    private static final Logger log = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository repo;
    private final AddressService addressService;
    private final CollegeService collegeService;
    private final Producer producer;

    private final Gson gson = new Gson();

    @Autowired
    public StudentService(StudentRepository repo, AddressService addressService, CollegeService collegeService, Producer producer) {
        this.repo = repo;
        this.addressService = addressService;
        this.collegeService = collegeService;
        this.producer = producer;
    }

    @Transactional
    public Student saveNewStudent(Student newStudent) {
        validateStudent(newStudent);

        College college = newStudent.getCollege();
        String collegeName = college.getCollegeName();
        Optional<College> clg = collegeService.findCollege(collegeName);
        if (clg.isEmpty()) {
            college = collegeService.save(new College(collegeName, new Address(), List.of()));
        }
        newStudent.setCollege(college);

        Student student = repo.save(newStudent);
        log.info("saved new student: {}", student);

        sendNotification(student);

        return student;
    }

    private void sendNotification(Student student) {
        StudentProduce produce = new StudentProduce(
                student.getId(),
                student.getStudentName(),
                student.getStudentEmail(),
                student.getStudentClass(),
                student.getAddress().toString(),
                student.getCollege().getCollegeName());
        String json = gson.toJson(produce);
        producer.sendMessage(json);
    }

    private void validateStudent(Student newStudent) {
        if (StringUtils.isEmpty(newStudent.getStudentName())) {
            throw new StudentException("Student name can not be empty");
        }

        if (StringUtils.isEmpty(newStudent.getStudentEmail())) {
            throw new StudentException("Student email can not be empty");
        }

        Address address = newStudent.getAddress();
        if (Objects.isNull(address)) {
            log.warn("Address is null for new student: {} ", newStudent.getStudentName());
        }

        College college = newStudent.getCollege();
        if (Objects.isNull(college)) {
            throw new StudentException("Student College can not be empty");
        }

        if (StringUtils.isEmpty(college.getCollegeName())) {
            throw new StudentException("College name can not be empty");
        }
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }
}
