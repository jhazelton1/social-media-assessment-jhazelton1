package com.cooksys.twitterspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ComponentScan(basePackages = "com.cooksys.twitterspring, com.cooksys.twitterspring.controllers, com.cooksys.twitterspring.dtos, com.cooksys.twitterspring.entities, com.cooksys.twitterspring.mappers, com.cooksys.twitterspring.repositories, com.cooksys.twitterspring.services")
public class TwitterSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterSpringApplication.class, args);
	}
}
