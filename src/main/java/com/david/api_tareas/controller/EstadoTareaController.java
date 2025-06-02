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

@RestController
@RequestMapping("/estadoTareas")
@Tag(name = "Estado tarea", description = "Operaciones relacionadas con los estados de la tarea")
public class EstadoTareaController {

	@Autowired
    private EstadoTareaService estadoTareaService;
	
	@GetMapping
    @Operation(summary = "Listar todos los estados de la tarea")
    public ResponseEntity<List<EstadoTareaOutputDTO>> listar() {
        return ResponseEntity.ok(estadoTareaService.listarTodas());
    }
}
