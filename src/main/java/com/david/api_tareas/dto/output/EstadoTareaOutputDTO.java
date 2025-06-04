package com.david.api_tareas.dto.output;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Genera automáticamente getters, setters, equals, hashCode y toString
@NoArgsConstructor // Constructor sin argumentos
@AllArgsConstructor // Constructor con todos los argumentos
@Builder // Permite crear objetos con el patrón builder
public class EstadoTareaOutputDTO {

	private Long id; // Identificador único del estado de la tarea
    private String nombreDelEstado; // Nombre o descripción del estado (por ejemplo, "En progreso")
    private LocalDateTime fechaModificacion; // Fecha y hora de la última modificación
	private LocalDateTime fechaCreacion; // Fecha y hora de creación del estado
}
