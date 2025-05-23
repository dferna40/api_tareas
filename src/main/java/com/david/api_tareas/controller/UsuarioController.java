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

@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuarios", description = "Operaciones relacionadas con usuarios")
public class UsuarioController {

	@Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @Operation(summary = "Crear un nuevo usuario")
    public UsuarioOutputDTO crearUsuario(@RequestBody UsuarioInputDTO dto) {
        return usuarioService.crearUsuario(dto);
    }
    
    @GetMapping("/usuarios")
    @Operation(summary = "Listar todos los usuarios")
    public ResponseEntity<List<UsuarioOutputDTO>> listarUsuarios() {
        List<UsuarioOutputDTO> usuarios = usuarioService.obtenerTodosLosUsuarios();
        return ResponseEntity.ok(usuarios);
    }
}
