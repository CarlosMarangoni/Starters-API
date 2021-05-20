package com.starters.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class StartersApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartersApiApplication.class, args);
	}

}
