package com.david.api_tareas.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.david.api_tareas.dto.output.TareaOutputDTO;
import com.david.api_tareas.mapper.TareaMapper;
import com.david.api_tareas.model.Tarea;
import com.david.api_tareas.repository.TareaRepository;
import com.david.api_tareas.service.TareaService;

@Service
public class TareaServiceImpl implements TareaService {

	@Autowired
    private TareaRepository tareaRepository;
	
	@Override
	public List<Tarea> listarTodas() {
        return tareaRepository.findAll();
    }

	@Override
    public Tarea guardar(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

	@Override
    public Optional<Tarea> buscarPorId(Long id) {
        return tareaRepository.findById(id);
    }

	@Override
    public void eliminar(Long id) {
        tareaRepository.deleteById(id);
    }
    
	@Override
    public List<TareaOutputDTO> obtenerTareasPorUsuario(Long usuarioId) {
        List<Tarea> tareas = tareaRepository.findByUsuarioId(usuarioId);
        return tareas.stream()
                     .map(TareaMapper::toDTO)
                     .collect(Collectors.toList());
    }
    
	@Override
    public List<TareaOutputDTO> obtenerTareasPorEstado(Long estadoId) {
        List<Tarea> tareas = tareaRepository.findByEstadoTareaId(estadoId);
        return tareas.stream()
                .map(TareaMapper::toDTO)
                .collect(Collectors.toList());
    }
	
	@Override
	public List<TareaOutputDTO> listarTodasDTO() {
	    return tareaRepository.findAll()
	        .stream()
	        .map(TareaMapper::toDTO)
	        .collect(Collectors.toList());
	}

	@Override
	public List<TareaOutputDTO> buscarPorTexto(String texto) {
		List<Tarea> tareas = tareaRepository.buscarPorTexto(texto);
		return tareas.stream()
		        .map(TareaMapper::toDTO)
		        .collect(Collectors.toList());
	}
	
	@Override
	public List<TareaOutputDTO> buscarPorUsuarioYEstado(Long usuarioId, Long estadoId) {
	    List<Tarea> tareas = tareaRepository.findByUsuarioIdAndEstadoTareaId(usuarioId, estadoId);
	    return tareas.stream()
	        .map(TareaMapper::toDTO)
	        .collect(Collectors.toList());
	}

	@Override
	public Page<TareaOutputDTO> listarPaginadas(Pageable pageable) {
	    return tareaRepository.findAll(pageable)
	        .map(TareaMapper::toDTO);
	}
}
