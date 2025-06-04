package com.david.api_tareas.mapper;

import java.time.LocalDateTime;

import com.david.api_tareas.dto.input.TareaInputDTO;
import com.david.api_tareas.dto.output.TareaOutputDTO;
import com.david.api_tareas.model.EstadoTarea;
import com.david.api_tareas.model.Tarea;
import com.david.api_tareas.model.Usuario;

// Clase que transforma objetos entre la entidad Tarea y sus DTOs de entrada y salida
public class TareaMapper {

    // Convierte una entidad Tarea en un DTO de salida para enviar al cliente
    public static TareaOutputDTO toDTO(Tarea tarea) {
        TareaOutputDTO dto = new TareaOutputDTO();
        dto.setId(tarea.getId());
        dto.setTitulo(tarea.getTitulo());
        dto.setDescripcion(tarea.getDescripcion());
        dto.setCompletada(tarea.isCompletada());
        dto.setUsuario(UsuarioMapper.toDTO(tarea.getUsuario())); // Convierte el usuario a su DTO
        dto.setEstadoTarea(EstadoTareaMapper.toDTO(tarea.getEstadoTarea())); // Convierte el estado a su DTO
        dto.setFechaCreacion(tarea.getFechaCreacion());
        dto.setFechaModificacion(tarea.getFechaModificacion());
        return dto;
    }

    // Convierte un DTO de entrada a una entidad Tarea para persistir en base de datos
    public static Tarea toEntity(TareaInputDTO dto, Usuario usuario, EstadoTarea estadoTarea) {
        Tarea tarea = new Tarea();
        tarea.setTitulo(dto.getTitulo());
        tarea.setDescripcion(dto.getDescripcion());
        tarea.setCompletada(dto.isCompletada());

        // ✅ Relaciones principales (Hibernate usará estas para persistir)
        tarea.setUsuario(usuario);
        tarea.setEstadoTarea(estadoTarea);

        // ✅ Fechas manuales si no usas auditoría automática
        tarea.setFechaCreacion(LocalDateTime.now());
        tarea.setFechaModificacion(LocalDateTime.now());

        return tarea;
    }
}
