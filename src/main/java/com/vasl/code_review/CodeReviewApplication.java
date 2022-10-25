package com.vasl.code_review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.vasl")
public class CodeReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeReviewApplication.class, args);
	}

}
