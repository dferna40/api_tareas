package com.david.api_tareas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.api_tareas.dto.output.EstadoTareaOutputDTO;
import com.david.api_tareas.service.EstadoTareaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController // Indica que esta clase es un controlador REST y sus métodos retornan datos directamente (JSON)
@RequestMapping("/estadoTareas") // Define la URL base para todas las rutas de este controlador
@Tag(name = "Estado tarea", description = "Operaciones relacionadas con los estados de la tarea") // Documentación para Swagger
public class EstadoTareaController {

	@Autowired
    private EstadoTareaService estadoTareaService; // Servicio que gestiona la lógica relacionada con los estados de tarea
	
	@GetMapping // Maneja las peticiones GET a la URL /estadoTareas
    @Operation(summary = "Listar todos los estados de la tarea") // Descripción breve para Swagger
    public ResponseEntity<List<EstadoTareaOutputDTO>> listar() {
        // Llama al servicio para obtener todos los estados y los retorna con HTTP 200 OK
        return ResponseEntity.ok(estadoTareaService.listarTodas());
    }
}
