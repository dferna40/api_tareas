package com.david.api_tareas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.david.api_tareas.dto.input.UsuarioInputDTO;
import com.david.api_tareas.dto.output.UsuarioOutputDTO;
import com.david.api_tareas.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/usuarios")
@Tag(name = "Usuarios", description = "Gestión del perfil de usuarios (no login)")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    @Operation(summary = "Listar todos los perfiles de usuario")
    public ResponseEntity<List<UsuarioOutputDTO>> listarUsuarios() {
        List<UsuarioOutputDTO> usuarios = usuarioService.obtenerTodosLosUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping
    @Operation(summary = "Crear perfil de usuario (paso 2 del registro)")
    public ResponseEntity<UsuarioOutputDTO> crearPerfilUsuario(@RequestBody UsuarioInputDTO dto) {
        UsuarioOutputDTO nuevoPerfil = usuarioService.crearPerfilUsuario(dto);
        return ResponseEntity.ok(nuevoPerfil);
    }
}
