package com.david.api_tareas.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.david.api_tareas.model.Tarea;

// Repositorio JPA para la entidad Tarea. Permite acceder a la base de datos sin escribir implementaciones.
public interface TareaRepository extends JpaRepository<Tarea, Long> {

	// Devuelve todas las tareas en formato paginado
	Page<Tarea> findAll(Pageable pageable);

	// Busca todas las tareas asociadas a un usuario por su ID
	List<Tarea> findByUsuarioId(Long id);
	
	// Busca todas las tareas que tienen un estado específico por su ID
	List<Tarea> findByEstadoTareaId(Long id);

	// Busca tareas cuyo título o descripción contengan el texto especificado (ignorando mayúsculas/minúsculas)
	@Query("SELECT t FROM Tarea t WHERE LOWER(t.titulo) LIKE LOWER(CONCAT('%', :texto, '%')) OR LOWER(t.descripcion) LIKE LOWER(CONCAT('%', :texto, '%'))")
	List<Tarea> buscarPorTexto(@Param("texto") String texto);
	
	// Busca tareas que coincidan tanto con un usuario como con un estado específico
	List<Tarea> findByUsuarioIdAndEstadoTareaId(Long usuarioId, Long estadoId);
}
