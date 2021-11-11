package com.mx.jmi.adminJMI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages ="com.mx.jmi.adminJMI.repository", repositoryImplementationPostfix = "CustomImpl")
public class AdminJmiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminJmiApplication.class, args);
		System.out.print("Init Admin Application");
	}

}
