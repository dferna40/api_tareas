package com.david.api_tareas.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Genera automáticamente getters, setters, equals, hashCode y toString
@NoArgsConstructor // Genera constructor sin argumentos
@AllArgsConstructor // Genera constructor con todos los campos
@Builder // Permite construir objetos con el patrón builder
public class EstadoTareaInputDTO {

	@NotBlank(message = "El nombre del estado no puede estar vacío") // Valida que el campo no sea nulo ni solo espacios
    @Size(max = 50, message = "El nombre del estado no puede superar los 50 caracteres") // Límite máximo de longitud
    private String nombreDelEstado; // Campo para capturar el nombre del estado de tarea desde el cliente
}
