package com.david.api_tareas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController // Marca la clase como un controlador REST, que devuelve datos (normalmente JSON)
@RequestMapping("/api/ping") // Define la ruta base del controlador: /api/ping
@Tag(name = "Prueba", description = "Ping de salud del sistema") // Etiqueta y descripción para Swagger/OpenAPI
public class PingController {

    @GetMapping // Maneja las peticiones GET a /api/ping
    @Operation(summary = "Comprobar si la API está viva") // Descripción breve para la documentación Swagger
    public ResponseEntity<String> ping() {
        // Devuelve "pong" con código HTTP 200 OK como prueba de vida de la API
        return ResponseEntity.ok("pong");
    }
}
