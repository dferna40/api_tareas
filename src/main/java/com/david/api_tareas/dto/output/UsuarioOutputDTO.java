package com.david.api_tareas.dto.output;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Genera automáticamente getters, setters, equals, hashCode y toString
@NoArgsConstructor // Constructor sin argumentos
@AllArgsConstructor // Constructor con todos los campos
@Builder // Permite construir objetos con el patrón builder
public class UsuarioOutputDTO {

	private Long id; // Identificador único del usuario
	private String nombre; // Nombre del usuario
	private String puesto; // Cargo o función que desempeña el usuario
	private String email; // Correo electrónico del usuario
	private LocalDateTime fechaModificacion; // Fecha y hora de la última modificación del usuario
	private LocalDateTime fechaCreacion; // Fecha y hora en que se creó el usuario
}
