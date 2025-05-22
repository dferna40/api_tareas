package com.david.api_tareas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.david.api_tareas.model.EstadoTarea;

@Repository
public interface EstadoTareaRepository extends JpaRepository<EstadoTarea, Long> {
	Optional<EstadoTarea> findByNombreDelEstado(String nombreDelEstado);
}
