package com.david.api_tareas.mapper;

import java.time.LocalDateTime;

import com.david.api_tareas.dto.input.UsuarioInputDTO;
import com.david.api_tareas.dto.output.UsuarioOutputDTO;
import com.david.api_tareas.model.Usuario;

public class UsuarioMapper {

	public static UsuarioOutputDTO toDTO(Usuario usuario) {
		UsuarioOutputDTO dto = new UsuarioOutputDTO();
		dto.setId(usuario.getId());
		dto.setNombre(usuario.getNombre());
		dto.setPuesto(usuario.getPuesto());
		dto.setCorreo(usuario.getCorreo());
		return dto;
	}

	public static Usuario toEntity(UsuarioInputDTO inputDTO) {
		Usuario usuario = new Usuario();
		usuario.setNombre(inputDTO.getNombre());
		usuario.setPuesto(inputDTO.getPuesto());
		usuario.setPassword(inputDTO.getPassword());
		usuario.setCorreo(inputDTO.getCorreo());
		usuario.setFechaCreacion(LocalDateTime.now());
		usuario.setFechaModificacion(LocalDateTime.now());
		return usuario;
	}

}
