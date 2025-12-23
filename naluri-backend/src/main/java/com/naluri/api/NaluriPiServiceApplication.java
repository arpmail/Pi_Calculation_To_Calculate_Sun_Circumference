package com.naluri.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NaluriPiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaluriPiServiceApplication.class, args);
	}

}
