package com.mx.jmi.adminJMI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdminJmiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminJmiApplication.class, args);
		System.out.print("Init Admin Application");
	}

}
