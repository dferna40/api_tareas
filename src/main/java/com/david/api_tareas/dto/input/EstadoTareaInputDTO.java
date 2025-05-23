package com.david.api_tareas.dto.input;

import jakarta.validation.constraints.NotBlank;

public class EstadoTareaInputDTO {

	@NotBlank(message = "El nombre del estado es obligatorio")
    private String nombreDelEstado;

    public String getNombreDelEstado() {
        return nombreDelEstado;
    }

    public void setNombreDelEstado(String nombreDelEstado) {
        this.nombreDelEstado = nombreDelEstado;
    }
}
