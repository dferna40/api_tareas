package com.david.api_tareas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "estados_tarea")
public class EstadoTarea {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado_tarea")
    private Long id_estadoTarea;
	
	@Column(name = "nombre_del_estado", nullable = false, unique = true)
	@NotBlank(message = "El nombre del estado es obligatorio")
	private String nombreDelEstado;

    // Constructores
    public EstadoTarea() {}

    public EstadoTarea(String nombreDelEstado) {
        this.nombreDelEstado = nombreDelEstado;
    }

    // Getters y Setters
    public Long getId() {
        return id_estadoTarea;
    }

    public String getNombreDelEstado() {
        return nombreDelEstado;
    }

    public void setNombreDelEstado(String nombreDelEstado) {
        this.nombreDelEstado = nombreDelEstado;
    }
    

}
