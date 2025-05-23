package com.david.api_tareas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tarea")
public class Tarea {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tarea")
    private Long id_tarea;
    private String titulo;
    private String descripcion;
    private boolean completada;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    // Relación con EstadoTarea (Muchos a Uno)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_tarea", nullable = false)
    private EstadoTarea estadoTarea;
    
    public Tarea() {} 
    
	public Tarea(Long id, String titulo, String descripcion, boolean completada) {
		super();
		this.id_tarea = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.completada = completada;
	}

	public Long getId() {
		return id_tarea;
	}
	public void setId(Long id) {
		this.id_tarea = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isCompletada() {
		return completada;
	}
	public void setCompletada(boolean completada) {
		this.completada = completada;
	}

	public Long getId_tarea() {
		return id_tarea;
	}

	public void setId_tarea(Long id_tarea) {
		this.id_tarea = id_tarea;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public EstadoTarea getEstadoTarea() {
		return estadoTarea;
	}

	public void setEstadoTarea(EstadoTarea estadoTarea) {
		this.estadoTarea = estadoTarea;
	}
}
