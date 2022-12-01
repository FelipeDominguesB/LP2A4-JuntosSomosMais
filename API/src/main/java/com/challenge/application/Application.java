package com.challenge.application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"com.example.application"})
@ComponentScan(basePackages = { "com.challenge.controllers", "com.challenge.services", "com.challenge.repositories"} )
@EntityScan("com.challenge.models")
@EnableJpaRepositories("com.challenge.repositories")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
