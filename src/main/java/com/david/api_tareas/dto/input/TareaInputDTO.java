package com.david.api_tareas.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Genera automáticamente getters, setters, equals, hashCode y toString
@NoArgsConstructor // Constructor sin argumentos
@AllArgsConstructor // Constructor con todos los argumentos
@Builder // Permite construir objetos con el patrón builder
public class TareaInputDTO {

	@NotBlank(message = "El título es obligatorio") // El título no puede estar vacío ni contener solo espacios
    @Size(min = 3, max = 100, message = "El título debe tener entre 3 y 100 caracteres") // Longitud mínima y máxima permitida
    private String titulo;

	@NotBlank(message = "La descripción es obligatoria") // La descripción no puede estar vacía
    @Size(max = 500, message = "La descripción no puede superar los 500 caracteres") // Longitud máxima de la descripción
    private String descripcion;

    @NotNull(message = "El ID del usuario es obligatorio") // El ID del usuario debe estar presente
    private Long usuarioId;

    @NotNull(message = "Debe especificarse el ID del estado de la tarea") // El ID del estado de la tarea también es requerido
    private Long estadoTareaId;
    
    private boolean completada; // Indica si la tarea ya está completada (opcional en validación)
}
