package io.matoshri.learn.college;

import io.matoshri.learn.address.Address;
import io.matoshri.learn.address.AddressService;
import io.matoshri.learn.exception.CollegeException;
import io.matoshri.learn.kafka.Producer;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CollegeService {
    private static final Logger log = LoggerFactory.getLogger(CollegeService.class);

    private final CollegeRepository repo;
    private final Producer producer;

    public CollegeService(CollegeRepository repo, Producer producer) {
        this.repo = repo;
        this.producer = producer;
    }


    @Transactional
    public College save(College college) {
        validateCollege(college);

//        Address address = college.getAddress();
//        address = addressService.saveAddress(address);
//        college.setAddress(address);

        college = repo.save(college);

        producer.sendMessage(college.toString());
        return college;
    }

    private void validateCollege(College college) {
        if (Objects.isNull(college)) {
            throw new CollegeException("College can not be null");
        }

        if (StringUtils.isEmpty(college.getCollegeName())) {
            throw new CollegeException("College name can not be empty");
        }

        if (Objects.isNull(college.getAddress())) {
            throw new CollegeException("College address can not be null");
        }
    }

    public List<College> getAll() {
        return repo.findAll();
    }

    public boolean isCollegeExistsById(int collegeId) {
        return repo.existsById(collegeId);
    }

    public College getCollege(int collegeId) {
        return repo.findById(collegeId)
                .orElseThrow(() -> new CollegeException("College ID doesn't exists"));
    }

    public Optional<College> findCollege(String collegeName) {
        return repo.findAll().stream()
                .filter(c -> c.getCollegeName().equalsIgnoreCase(collegeName))
                .findFirst();
    }
}
