package com.projects.kora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class KoraApplication {
	public static void main(String[] args) {
		SpringApplication.run(KoraApplication.class, args);
	}

}
