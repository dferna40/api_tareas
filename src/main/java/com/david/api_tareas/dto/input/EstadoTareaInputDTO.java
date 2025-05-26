package com.david.api_tareas.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EstadoTareaInputDTO {

	@NotBlank(message = "El nombre del estado no puede estar vacío")
    @Size(max = 50, message = "El nombre del estado no puede superar los 50 caracteres")
    private String nombreDelEstado;

    public String getNombreDelEstado() {
        return nombreDelEstado;
    }

    public void setNombreDelEstado(String nombreDelEstado) {
        this.nombreDelEstado = nombreDelEstado;
    }
}
