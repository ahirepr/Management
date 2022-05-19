package com.ness.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EmployeeManagement {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagement.class, args);
	}
	


}
