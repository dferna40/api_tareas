package com.david.api_tareas.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.david.api_tareas.model.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
	
	Page<Tarea> findAll(Pageable pageable);

	List<Tarea> findByUsuarioId(Long id);
	
	List<Tarea> findByEstadoTareaId(Long id);

	@Query("SELECT t FROM Tarea t WHERE LOWER(t.titulo) LIKE LOWER(CONCAT('%', :texto, '%')) OR LOWER(t.descripcion) LIKE LOWER(CONCAT('%', :texto, '%'))")
	List<Tarea> buscarPorTexto(@Param("texto") String texto);
	
	List<Tarea> findByUsuarioIdAndEstadoTareaId(Long usuarioId, Long estadoId);
}
