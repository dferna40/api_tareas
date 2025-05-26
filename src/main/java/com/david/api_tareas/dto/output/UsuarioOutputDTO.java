package com.david.api_tareas.dto.output;

public class UsuarioOutputDTO {

	private Long id;
	private String nombre;
	private String puesto;
	private String correo;

	
	public Long getId_usuario() {
		return id;
	}
	public void setId_usuario(Long id_usuario) {
		this.id = id_usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return puesto;
	}
	public void setDescripcion(String descripcion) {
		this.puesto = descripcion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
}
