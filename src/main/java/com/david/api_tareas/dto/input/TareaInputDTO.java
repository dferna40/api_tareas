package com.david.api_tareas.dto.input;

public class TareaInputDTO {

	private String titulo;
    private Long idUsuario;       // solo necesitas el ID para asociarlo
    private Long idEstadoTarea;
    private String descripcion;
    
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Long getIdEstadoTarea() {
		return idEstadoTarea;
	}
	public void setIdEstadoTarea(Long idEstadoTarea) {
		this.idEstadoTarea = idEstadoTarea;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
    
    
}
