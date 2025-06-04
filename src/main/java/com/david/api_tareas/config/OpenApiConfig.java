package com.david.api_tareas.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Clase de configuración para Swagger/OpenAPI 3.0 usando springdoc-openapi
@Configuration
public class OpenApiConfig {

	// Define un bean de tipo OpenAPI que configura la documentación de la API
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				// Información general de la API que se mostrará en Swagger UI
				.info(new Info()
						.title("API de Gestión de Tareas") // Título del documento
						.version("1.0.0") // Versión de la API
						.description("Documentación de la API para gestionar tareas, usuarios y estados")) // Descripción visible
				// Requiere el esquema de seguridad llamado "bearerAuth" para todas las operaciones protegidas
				.addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
				// Define el esquema de autenticación JWT tipo Bearer
				.components(new Components().addSecuritySchemes("bearerAuth", 
						new SecurityScheme()
							.name("bearerAuth")
							.type(SecurityScheme.Type.HTTP)
							.scheme("bearer")
							.bearerFormat("JWT")));
	}
}
