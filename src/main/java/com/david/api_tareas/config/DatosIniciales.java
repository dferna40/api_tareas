package com.david.api_tareas.config;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.david.api_tareas.model.EstadoTarea;
import com.david.api_tareas.repository.EstadoTareaRepository;

// Clase de configuración que define beans para la inicialización de datos
@Configuration
public class DatosIniciales {

    // Define un bean que se ejecuta al iniciar la aplicación, pero solo si el perfil activo NO es "test"
    @Bean
    @Profile("!test") // 🚫 Este bean se omite cuando el perfil activo es "test"
    public CommandLineRunner cargarEstadosPorDefecto(EstadoTareaRepository estadoTareaRepository) {
        return args -> {
            System.out.println(">>> Ejecutando CommandLineRunner...");

            // Lista de nombres de estados que se insertarán si no existen
            List<String> estadosPorDefecto = Arrays.asList("Sin estado", "Por hacer", "En progreso", "Hecho");

            // Recorre los estados por defecto y los guarda si aún no existen en la base de datos
            for (String nombre : estadosPorDefecto) {
                Optional<EstadoTarea> existente = estadoTareaRepository.findByNombreDelEstado(nombre);
                System.out.println("¿Existe '" + nombre + "'? -> " + existente.isPresent());

                if (existente.isEmpty()) {
                    estadoTareaRepository.save(new EstadoTarea(nombre));
                    System.out.println(">>> Estado insertado: " + nombre);
                }
            }
        };
    }
}
