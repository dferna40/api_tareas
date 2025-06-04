package com.david.api_tareas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.david.api_tareas.model.EstadoTarea;

@Repository // Indica que esta interfaz es un componente de repositorio de Spring (especialmente útil para inyección de dependencias)
public interface EstadoTareaRepository extends JpaRepository<EstadoTarea, Long> {

	// Método de consulta personalizado que busca un estado por su nombre
	// Spring Data JPA lo implementa automáticamente por convención de nombres
	Optional<EstadoTarea> findByNombreDelEstado(String nombreDelEstado);
}
