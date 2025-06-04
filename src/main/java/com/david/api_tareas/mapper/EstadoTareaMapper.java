package com.david.api_tareas.mapper;

import java.time.LocalDateTime;

import com.david.api_tareas.dto.input.EstadoTareaInputDTO;
import com.david.api_tareas.dto.output.EstadoTareaOutputDTO;
import com.david.api_tareas.model.EstadoTarea;

// Clase utilitaria que convierte entre entidades EstadoTarea y sus DTOs correspondientes
public class EstadoTareaMapper {

	// Convierte una entidad EstadoTarea a un DTO de salida
	public static EstadoTareaOutputDTO toDTO(EstadoTarea estadoTarea) {
		EstadoTareaOutputDTO dto = new EstadoTareaOutputDTO();
		dto.setId(estadoTarea.getId());
		dto.setNombreDelEstado(estadoTarea.getNombreDelEstado());
		return dto;
	}

	// Convierte un DTO de entrada a una entidad EstadoTarea
	public static EstadoTarea toEntity(EstadoTareaInputDTO inputDTO) {
		EstadoTarea estado = new EstadoTarea();
		estado.setNombreDelEstado(inputDTO.getNombreDelEstado());
		estado.setFechaCreacion(LocalDateTime.now()); // Se establece la fecha actual como creación
		estado.setFechaModificacion(LocalDateTime.now()); // También como modificación inicial
		return estado;
	}
}
