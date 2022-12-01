package com.challenge.application;
import com.challenge.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.challenge.controllers"} )

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
