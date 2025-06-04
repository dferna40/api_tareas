package com.david.api_tareas.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.david.api_tareas.ApiTareasApplication;

// Clase necesaria para desplegar la aplicación en un servidor externo (por ejemplo, Tomcat como WAR)
public class ServletInitializer extends SpringBootServletInitializer {

	// Este método configura la clase principal de arranque cuando se despliega como WAR
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		// Especifica cuál es la clase principal (con @SpringBootApplication)
		return application.sources(ApiTareasApplication.class);
	}

}
