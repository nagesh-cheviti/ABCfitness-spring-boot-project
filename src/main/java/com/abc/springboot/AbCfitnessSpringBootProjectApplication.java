package com.abc.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.abc.springboot")
public class AbCfitnessSpringBootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbCfitnessSpringBootProjectApplication.class, args);
	}

}
