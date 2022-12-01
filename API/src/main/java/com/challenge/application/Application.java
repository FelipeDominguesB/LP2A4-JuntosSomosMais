package com.challenge.application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages={"com.example.application"})
@ComponentScan(basePackages = { "com.challenge.controllers", "com.challenge.services", "com.challenge.repositories"} )

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
