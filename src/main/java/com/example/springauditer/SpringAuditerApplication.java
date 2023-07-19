package com.example.springauditer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringAuditerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAuditerApplication.class, args);
	}

}
