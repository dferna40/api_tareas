package com.david.api_tareas.config;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.david.api_tareas.model.EstadoTarea;
import com.david.api_tareas.model.Puesto;
import com.david.api_tareas.repository.EstadoTareaRepository;
import com.david.api_tareas.repository.PuestoRepository;

@Configuration
public class DatosIniciales {

    @Bean
    @Profile("!test")
    public CommandLineRunner cargarDatosIniciales(
            EstadoTareaRepository estadoTareaRepository,
            PuestoRepository puestoRepository) {

        return args -> {
            System.out.println(">>> Ejecutando CommandLineRunner para datos iniciales...");

            // ---------- ESTADOS ----------
            List<String> estadosPorDefecto = Arrays.asList("Sin estado", "Por hacer", "En progreso", "Hecho");

            for (String nombre : estadosPorDefecto) {
                Optional<EstadoTarea> existente = estadoTareaRepository.findByNombreDelEstado(nombre);
                if (existente.isEmpty()) {
                    estadoTareaRepository.save(new EstadoTarea(nombre));
                    System.out.println("✔ Estado insertado: " + nombre);
                }
            }

            // ---------- PUESTOS ----------
            List<String> puestosPorDefecto = Arrays.asList(
                "Programador Junior Web",
                "Programador Web",
                "Programador Senior Web",
                "Desarrollador Frontend",
                "Desarrollador Backend",
                "Desarrollador Full Stack",
                "Desarrollador de APIs REST",
                "Integrador Web",
                "Analista Programador Web",
                "Analista Funcional Web",
                "Jefe de Proyecto Web",
                "Jefe de Equipo Técnico",
                "Arquitecto Web",
                "Scrum Master",
                "Consultor Web",
                "Desarrollador DevOps Web",
                "Especialista en UX/UI",
                "QA Tester Web"
            );

            for (String nombre : puestosPorDefecto) {
                Optional<Puesto> existente = puestoRepository.findByNombre(nombre);
                if (existente.isEmpty()) {
                    puestoRepository.save(new Puesto(nombre));
                    System.out.println("✔ Puesto insertado: " + nombre);
                }
            }
        };
    }
}
