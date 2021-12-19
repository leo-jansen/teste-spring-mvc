package com.example.spring.testespringmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class TesteSpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteSpringMvcApplication.class, args);
	}

}
