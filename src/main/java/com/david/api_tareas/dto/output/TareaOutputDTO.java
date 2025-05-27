package com.david.api_tareas.dto.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TareaOutputDTO {

	private Long id;
	private String titulo;
	private String descripcion;
	private boolean completada;
	private UsuarioOutputDTO usuario;
	private EstadoTareaOutputDTO estadoTarea;
}
