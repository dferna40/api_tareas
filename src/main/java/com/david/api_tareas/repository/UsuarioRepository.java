package com.david.api_tareas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.david.api_tareas.model.Usuario;

// Repositorio JPA para la entidad Usuario.
// Hereda todos los métodos CRUD, paginación y ordenación de JpaRepository.
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	// No se definen métodos adicionales, pero podrías añadir métodos personalizados si lo necesitas.
}
