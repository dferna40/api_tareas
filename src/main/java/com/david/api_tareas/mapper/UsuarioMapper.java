package com.david.api_tareas.mapper;

import java.time.LocalDateTime;

import com.david.api_tareas.dto.input.UsuarioInputDTO;
import com.david.api_tareas.dto.output.UsuarioOutputDTO;
import com.david.api_tareas.model.Usuario;

// Clase utilitaria que convierte entre la entidad Usuario y sus DTOs
public class UsuarioMapper {

    // Convierte un objeto Usuario (entidad) en un DTO de salida
    public static UsuarioOutputDTO toDTO(Usuario usuario) {
        UsuarioOutputDTO dto = new UsuarioOutputDTO();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setPuesto(usuario.getPuesto());
        dto.setEmail(usuario.getEmail());
        return dto;
    }

    // Convierte un DTO de entrada en una entidad Usuario
    public static Usuario toEntity(UsuarioInputDTO inputDTO) {
        Usuario usuario = new Usuario();
        usuario.setNombre(inputDTO.getNombre());
        usuario.setPuesto(inputDTO.getPuesto());
        usuario.setPassword(inputDTO.getPassword()); // ⚠️ Se debe encriptar luego en el servicio
        usuario.setEmail(inputDTO.getEmail());
        usuario.setFechaCreacion(LocalDateTime.now()); // Fecha de alta
        usuario.setFechaModificacion(LocalDateTime.now()); // Fecha de modificación inicial
        return usuario;
    }
}
