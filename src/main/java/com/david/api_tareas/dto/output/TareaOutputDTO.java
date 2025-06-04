package com.david.api_tareas.dto.output;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Genera getters, setters, equals, hashCode y toString automáticamente
@NoArgsConstructor // Constructor sin argumentos
@AllArgsConstructor // Constructor con todos los campos
@Builder // Permite construir objetos con el patrón builder
public class TareaOutputDTO {

	private Long id; // Identificador único de la tarea
	private String titulo; // Título de la tarea
	private String descripcion; // Descripción detallada de la tarea
	private boolean completada; // Indica si la tarea está completada o no

	private UsuarioOutputDTO usuario; // Información del usuario asociado a la tarea
	private EstadoTareaOutputDTO estadoTarea; // Estado actual de la tarea (por ejemplo, "Por hacer")

	private LocalDateTime fechaModificacion; // Fecha y hora de la última modificación
	private LocalDateTime fechaCreacion; // Fecha y hora de creación
}
