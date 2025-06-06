package com.david.api_tareas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.david.api_tareas.dto.input.UsuarioInputDTO;
import com.david.api_tareas.model.Usuario;

// Repositorio JPA para la entidad Usuario.
// Hereda todos los métodos CRUD, paginación y ordenación de JpaRepository.
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	boolean existsByEmail(String email);
	
	Optional<Usuario> findByEmail(String email);
}
