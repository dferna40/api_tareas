package com.david.api_tareas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.david.api_tareas.model.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Long> {

	List<Tarea> findByUsuarioId(Long usuarioId);

}
