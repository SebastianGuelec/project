package com.textify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class TextifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TextifyApplication.class, args);
	}

}
