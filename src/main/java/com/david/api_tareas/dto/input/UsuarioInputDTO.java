package com.david.api_tareas.dto.input;

import jakarta.validation.constraints.NotBlank;

public class UsuarioInputDTO {

	@NotBlank(message = "El nombre del usuario es obligatorio")
    private String nombre;

    @NotBlank(message = "La descripción del usuario es obligatoria")
    private String descripcion;

    @NotBlank(message = "La contraseña es obligatoria")
    private String password;

    // Getters y Setters

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
