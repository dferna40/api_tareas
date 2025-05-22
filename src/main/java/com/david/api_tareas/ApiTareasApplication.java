package com.david.api_tareas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.david.api_tareas")
public class ApiTareasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTareasApplication.class, args);
	}

}
