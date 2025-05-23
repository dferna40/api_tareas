package com.david.api_tareas.dto.output;

public class EstadoTareaOutputDTO {

	private Long id;
    private String nombreDelEstado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreDelEstado() {
        return nombreDelEstado;
    }

    public void setNombreDelEstado(String nombreDelEstado) {
        this.nombreDelEstado = nombreDelEstado;
    }
}
