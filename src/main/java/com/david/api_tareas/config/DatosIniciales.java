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

@Configuration
public class DatosIniciales {

    @Bean
    @Profile("!test") // 🚫 No se ejecuta en tests
    public CommandLineRunner cargarEstadosPorDefecto(EstadoTareaRepository estadoTareaRepository) {
        return args -> {
            System.out.println(">>> Ejecutando CommandLineRunner...");

            List<String> estadosPorDefecto = Arrays.asList("Sin estado", "Por hacer", "En progreso", "Hecho");

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
