package com.david.api_tareas.mapper;

import java.time.LocalDateTime;

import com.david.api_tareas.dto.input.TareaInputDTO;
import com.david.api_tareas.dto.output.TareaOutputDTO;
import com.david.api_tareas.model.EstadoTarea;
import com.david.api_tareas.model.Tarea;
import com.david.api_tareas.model.Usuario;

public class TareaMapper {

	public static TareaOutputDTO toDTO(Tarea tarea) {
		TareaOutputDTO dto = new TareaOutputDTO();
		dto.setId(tarea.getId());
		dto.setTitulo(tarea.getTitulo());
		dto.setDescripcion(tarea.getDescripcion());
		dto.setUsuario(UsuarioMapper.toDTO(tarea.getUsuario()));
		dto.setEstadoTarea(EstadoTareaMapper.toDTO(tarea.getEstadoTarea()));
		return dto;
	}

	public static Tarea toEntity(TareaInputDTO dto, Usuario usuario, EstadoTarea estadoTarea) {
	    Tarea tarea = new Tarea();
	    
	    tarea.setTitulo(dto.getTitulo());
	    tarea.setDescripcion(dto.getDescripcion());
	    tarea.setUsuarioId(usuario.getId());               // 🔥 Clave para que se inserte bien
	    tarea.setEstadoTareaId(estadoTarea.getId());       // 🔥 Clave para que se inserte bien
	    tarea.setUsuario(usuario);                         // solo para lectura si necesitas en el DTO de salida
	    tarea.setEstadoTarea(estadoTarea);                 // solo para lectura si necesitas en el DTO de salida
	    tarea.setFechaCreacion(LocalDateTime.now());
	    tarea.setFechaModificacion(LocalDateTime.now());
	    
	    return tarea;
	}

}
