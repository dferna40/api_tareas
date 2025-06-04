package com.david.api_tareas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration // Marca esta clase como una fuente de configuración
@EnableWebSecurity // Habilita la seguridad web de Spring Security
public class SecurityConfig {
	
	// Bean que define el encoder de contraseñas usando BCrypt (ideal para almacenar contraseñas cifradas)
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

	// Configura la cadena de filtros de seguridad de Spring
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthFilter jwtAuthFilter) throws Exception {
	    return http
	            .csrf(csrf -> csrf.disable()) // Desactiva CSRF (útil en APIs REST)
	            .authorizeHttpRequests(auth -> auth
	                    // Estas rutas son públicas (no requieren autenticación)
	                    .requestMatchers("/auth/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
	                    // Todas las demás rutas requieren autenticación
	                    .anyRequest().authenticated()
	            )
	            // Añade el filtro JWT personalizado antes del filtro por defecto de usuario/contraseña
	            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
	            .build();
	}

	// Bean que define un usuario en memoria (solo para pruebas rápidas o desarrollo)
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("admin")
            .password("admin123") // ⚠️ Esta contraseña está sin cifrar: solo para pruebas
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }

}
