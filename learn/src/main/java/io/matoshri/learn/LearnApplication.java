package io.matoshri.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/learn");
		SpringApplication.run(LearnApplication.class, args);
	}

}
