package com.study.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class Study1Application {

	public static void main(String[] args) {
		SpringApplication.run(Study1Application.class, args);
		log.debug("study app started");
	}

}
