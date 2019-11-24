package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeePortalApplication {
	private static final Logger LOGGER1 = LoggerFactory.getLogger(EmployeePortalApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmployeePortalApplication.class, args);
		LOGGER1.info("\n\n*************************** EMPLOYEE PORTAL SERVICE APPLICATION STARTED ***************************\n");
	}

}
