package com.david.api_tareas.mapper;

import java.time.LocalDateTime;

import com.david.api_tareas.dto.input.EstadoTareaInputDTO;
import com.david.api_tareas.dto.output.EstadoTareaOutputDTO;
import com.david.api_tareas.model.EstadoTarea;

public class EstadoTareaMapper {

	public static EstadoTareaOutputDTO toDTO(EstadoTarea estadoTarea) {
		EstadoTareaOutputDTO dto = new EstadoTareaOutputDTO();
		dto.setId(estadoTarea.getId());
		dto.setNombreDelEstado(estadoTarea.getNombreDelEstado());
		return dto;
	}

	public static EstadoTarea toEntity(EstadoTareaInputDTO inputDTO) {
		EstadoTarea estado = new EstadoTarea();
		estado.setNombreDelEstado(inputDTO.getNombreDelEstado());
		estado.setFechaCreacion(LocalDateTime.now());
		estado.setFechaModificacion(LocalDateTime.now());
		return estado;
	}

}
