package com.greedy.datatests.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.greedy.datatests"})
public class ChapSpringDataJpaTestsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChapSpringDataJpaTestsApplication.class, args);
	}

}
