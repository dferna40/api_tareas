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
	    dto.setEmail(usuario.getEmail());

	    if (usuario.getPuesto() != null) {
	        dto.setPuesto(PuestoMapper.toDTO(usuario.getPuesto()));
	    }

	    return dto;
	}

    // Convierte un DTO de entrada en una entidad Usuario
	public static Usuario toEntity(UsuarioInputDTO inputDTO) {
	    Usuario usuario = new Usuario();
	    usuario.setNombre(inputDTO.getNombre());
	    usuario.setPassword(inputDTO.getPassword());
	    usuario.setEmail(inputDTO.getEmail());
	    usuario.setFechaCreacion(LocalDateTime.now());
	    usuario.setFechaModificacion(LocalDateTime.now());
	    return usuario;
	}
}
