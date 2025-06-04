package com.david.api_tareas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.api_tareas.dto.input.EstadoTareaInputDTO;
import com.david.api_tareas.dto.output.EstadoTareaOutputDTO;
import com.david.api_tareas.mapper.EstadoTareaMapper;
import com.david.api_tareas.model.EstadoTarea;
import com.david.api_tareas.repository.EstadoTareaRepository;

@Service // Marca esta clase como un servicio para que Spring la detecte como componente
public class EstadoTareaService {

	@Autowired
    private EstadoTareaRepository estadoTareaRepository; // Inyección del repositorio de estados

	// Devuelve una lista de todos los estados de tarea convertidos a DTO de salida
	public List<EstadoTareaOutputDTO> listarTodas() {
        return estadoTareaRepository.findAll().stream()
                .map(EstadoTareaMapper::toDTO) // Convierte cada entidad a DTO
                .toList(); // Devuelve una lista de DTOs
    }

    // Crea un nuevo estado de tarea a partir de un DTO de entrada
    public EstadoTarea crear(EstadoTareaInputDTO inputDTO) {
        EstadoTarea estado = EstadoTareaMapper.toEntity(inputDTO); // Convierte el DTO en entidad
        return estadoTareaRepository.save(estado); // Persiste en la base de datos y retorna la entidad guardada
    }
}
