package com.example.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogAppApisFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApisFinalApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMaper() {
		return new ModelMapper();
	}

}
