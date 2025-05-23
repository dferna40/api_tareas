package com.david.api_tareas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
    private Long id_usuario;
    private String nombre;
    private String descripcion;
    private String password;
    
    public Usuario() {}
    
	public Usuario(Long id, String nombre, String descripcion, String password) {
		super();
		this.id_usuario = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.password = password;
	}

	public Long getId() {
		return id_usuario;
	}
	public void setId(Long id) {
		this.id_usuario = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    
}
