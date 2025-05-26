package com.david.api_tareas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "estado_tarea")
public class EstadoTarea {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
    private Long id;
	
	@Column(name = "nombre_del_estado", nullable = false, unique = true)
	@NotBlank(message = "El nombre del estado es obligatorio")
	private String nombreDelEstado;

    // Constructores
    public EstadoTarea() {}

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EstadoTarea(String nombreDelEstado) {
        this.nombreDelEstado = nombreDelEstado;
    }

    public String getNombreDelEstado() {
        return nombreDelEstado;
    }

    public void setNombreDelEstado(String nombreDelEstado) {
        this.nombreDelEstado = nombreDelEstado;
    }
    

}
