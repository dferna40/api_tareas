package com.david.api_tareas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.api_tareas.dto.input.EstadoTareaInputDTO;
import com.david.api_tareas.dto.output.EstadoTareaOutputDTO;
import com.david.api_tareas.mapper.EstadoTareaMapper;
import com.david.api_tareas.model.EstadoTarea;
import com.david.api_tareas.repository.EstadoTareaRepository;

@Service
public class EstadoTareaService {

	@Autowired
    private EstadoTareaRepository estadoTareaRepository;
	
	public List<EstadoTareaOutputDTO> listarTodas() {
        return estadoTareaRepository.findAll().stream()
                .map(EstadoTareaMapper::toDTO)
                .toList();
    }

    public EstadoTarea crear(EstadoTareaInputDTO inputDTO) {
        EstadoTarea estado = EstadoTareaMapper.toEntity(inputDTO);
        return estadoTareaRepository.save(estado);
    }
}
