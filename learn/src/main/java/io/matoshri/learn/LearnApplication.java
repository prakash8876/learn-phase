package io.matoshri.learn;

import io.matoshri.learn.address.Address;
import io.matoshri.learn.college.College;
import io.matoshri.learn.college.CollegeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class LearnApplication {

	private static final Logger log = LoggerFactory.getLogger(LearnApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LearnApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(CollegeService collegeService) {
		return (args -> {
			this.insertCollege(collegeService);
			log.info("Inserted colleges: {}", collegeService.getAll());
		});
	}

	private void insertCollege(CollegeService collegeService) {
		collegeService.save(new College("IIT", new Address(null, "","Banglore", ""), List.of()));
		collegeService.save(new College("RMD", new Address(null, "","Mumbai", ""), List.of()));
		collegeService.save(new College("MIT", new Address(null, "","Delhi", ""), List.of()));
	}

}
