package com.david.api_tareas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/ping")
@Tag(name = "Prueba", description = "Ping de salud del sistema")
public class PingController {

    @GetMapping
    @Operation(summary = "Comprobar si la API está viva")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");
    }
}
