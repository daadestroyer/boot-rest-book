package com.example.bootrestbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class BootrestbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootrestbookApplication.class, args);
		System.out.println("======================");
		System.out.println("started...");
		System.out.println("=======================");
	}

}
