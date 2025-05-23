package com.david.api_tareas.mapper;

import com.david.api_tareas.dto.input.UsuarioInputDTO;
import com.david.api_tareas.dto.output.UsuarioOutputDTO;
import com.david.api_tareas.model.Usuario;

public class UsuarioMapper {

	public static UsuarioOutputDTO toDTO(Usuario usuario) {
		UsuarioOutputDTO dto = new UsuarioOutputDTO();
		dto.setId_usuario(usuario.getId());
		dto.setNombre(usuario.getNombre());
		dto.setDescripcion(usuario.getDescripcion());
		return dto;
	}

	public static Usuario toEntity(UsuarioInputDTO inputDTO) {
		Usuario usuario = new Usuario();
		usuario.setNombre(inputDTO.getNombre());
		usuario.setDescripcion(inputDTO.getDescripcion());
		usuario.setPassword(inputDTO.getPassword());
		return usuario;
	}

}
