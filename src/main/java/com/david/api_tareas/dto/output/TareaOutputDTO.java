package com.david.api_tareas.dto.output;

public class TareaOutputDTO {

	private Long id_tarea;
	private String titulo;
	private String descripcion;
	private boolean completada;
	private UsuarioOutputDTO usuario;
	private EstadoTareaOutputDTO estadoTarea;
	
	public Long getId_tarea() {
		return id_tarea;
	}
	public void setId_tarea(Long id_tarea) {
		this.id_tarea = id_tarea;
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
	public UsuarioOutputDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioOutputDTO usuario) {
		this.usuario = usuario;
	}
	public EstadoTareaOutputDTO getEstadoTarea() {
		return estadoTarea;
	}
	public void setEstadoTarea(EstadoTareaOutputDTO estadoTarea) {
		this.estadoTarea = estadoTarea;
	}

	
}
