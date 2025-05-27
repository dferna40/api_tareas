package com.david.api_tareas.dto.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstadoTareaOutputDTO {

	private Long id;
    private String nombreDelEstado;
}
