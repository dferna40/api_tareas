package com.david.api_tareas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.david.api_tareas.model.Puesto;

public interface PuestoRepository extends JpaRepository<Puesto, Long> {
	
	Optional<Puesto> findByNombre(String nombre);
}