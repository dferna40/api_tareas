package com.david.api_tareas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.api_tareas.dto.input.UsuarioInputDTO;
import com.david.api_tareas.dto.output.UsuarioOutputDTO;
import com.david.api_tareas.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController // Define esta clase como un controlador REST
@RequestMapping("/usuarios") // URL base para este controlador
@Tag(name = "Usuarios", description = "Operaciones relacionadas con usuarios") // Documentación para Swagger
public class UsuarioController {

	@Autowired
    private UsuarioService usuarioService; // Servicio que contiene la lógica de negocio relacionada con usuarios

//    @PostMapping
//    @Operation(summary = "Crear usuario") // Endpoint para registrar un nuevo usuario
//    public ResponseEntity<UsuarioOutputDTO> crear(@Valid @RequestBody UsuarioInputDTO dto) {
//        // Llama al servicio para crear un nuevo usuario y devuelve el DTO de salida
//        UsuarioOutputDTO nuevoUsuario = usuarioService.crearUsuario(dto);
//        return ResponseEntity.ok(nuevoUsuario); // Devuelve HTTP 200 con el usuario creado
//    }

    @GetMapping
    @Operation(summary = "Listar todos los usuarios") // Endpoint para obtener la lista de todos los usuarios
    public ResponseEntity<List<UsuarioOutputDTO>> listarUsuarios() {
        // Llama al servicio para obtener todos los usuarios como DTOs
        List<UsuarioOutputDTO> usuarios = usuarioService.obtenerTodosLosUsuarios();
        return ResponseEntity.ok(usuarios); // Devuelve HTTP 200 con la lista de usuarios
    }
}
