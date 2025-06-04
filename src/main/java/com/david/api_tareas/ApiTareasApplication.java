package com.david.api_tareas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication // Anotación principal que habilita la configuración automática de Spring Boot y
						// escanea los componentes del paquete base
@EnableJpaAuditing // Habilita el soporte para auditoría en JPA (por ejemplo, @CreatedDate,
					// @LastModifiedDate)
@ComponentScan(basePackages = "com.david.api_tareas") // Indica a Spring qué paquete debe escanear para detectar beans,
														// controladores, servicios, etc.
public class ApiTareasApplication {

	public static void main(String[] args) {
		// Método principal que lanza la aplicación Spring Boot
		SpringApplication.run(ApiTareasApplication.class, args); // Arranca el contexto de Spring y la aplicación
	}

}
