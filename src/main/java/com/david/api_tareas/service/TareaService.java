package com.david.api_tareas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.david.api_tareas.dto.input.TareaInputDTO;
import com.david.api_tareas.dto.output.TareaOutputDTO;
import com.david.api_tareas.mapper.TareaMapper;
import com.david.api_tareas.model.EstadoTarea;
import com.david.api_tareas.model.Tarea;
import com.david.api_tareas.model.Usuario;
import com.david.api_tareas.repository.EstadoTareaRepository;
import com.david.api_tareas.repository.TareaRepository;
import com.david.api_tareas.repository.UsuarioRepository;

@Service
public class TareaService {

	@Autowired
	private TareaRepository tareaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private EstadoTareaRepository estadoTareaRepository;

	// Listar todas las tareas (convertidas a DTO)
	public List<TareaOutputDTO> obtenerTodasLasTareas() {
		return tareaRepository.findAll().stream().map(TareaMapper::toDTO).toList();
	}

	public TareaOutputDTO guardar(TareaInputDTO dto) {
		// Validación de campos obligatorios
		if (dto.getUsuarioId() == null || dto.getEstadoTareaId() == null) {
			throw new IllegalArgumentException("El usuarioId y estadoTareaId son obligatorios.");
		}

		// Recuperar entidades relacionadas
		Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

		EstadoTarea estado = estadoTareaRepository.findById(dto.getEstadoTareaId())
				.orElseThrow(() -> new RuntimeException("Estado no encontrado"));

		// Mapeo y guardado
		Tarea tarea = TareaMapper.toEntity(dto, usuario, estado);
		Tarea tareaGuardada = tareaRepository.save(tarea);

		return TareaMapper.toDTO(tareaGuardada);
	}

	// Obtener una tarea por ID (convertida a DTO)
	public TareaOutputDTO obtenerTareaPorId(Long id) {
		Tarea tarea = tareaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Tarea no encontrada con id: " + id));
		return TareaMapper.toDTO(tarea);
	}

	public void eliminar(Long id) {
		tareaRepository.deleteById(id);
	}

	public List<TareaOutputDTO> obtenerTareasPorUsuario(Long usuarioId) {
		List<Tarea> tareas = tareaRepository.findByUsuarioId(usuarioId);
		return tareas.stream().map(TareaMapper::toDTO).collect(Collectors.toList());
	}

	public List<TareaOutputDTO> obtenerTareasPorEstado(Long estadoId) {
		List<Tarea> tareas = tareaRepository.findByEstadoTareaId(estadoId);
		return tareas.stream().map(TareaMapper::toDTO).collect(Collectors.toList());
	}

	public List<TareaOutputDTO> listarTodasDTO() {
		return tareaRepository.findAll().stream().map(TareaMapper::toDTO).collect(Collectors.toList());
	}

	public List<TareaOutputDTO> buscarPorTexto(String texto) {
		List<Tarea> tareas = tareaRepository.buscarPorTexto(texto);
		return tareas.stream().map(TareaMapper::toDTO).collect(Collectors.toList());
	}

	public List<TareaOutputDTO> buscarPorUsuarioYEstado(Long usuarioId, Long estadoId) {
		List<Tarea> tareas = tareaRepository.findByUsuarioIdAndEstadoTareaId(usuarioId, estadoId);
		return tareas.stream().map(TareaMapper::toDTO).collect(Collectors.toList());
	}

	public Page<TareaOutputDTO> listarPaginadas(Pageable pageable) {
		return tareaRepository.findAll(pageable).map(TareaMapper::toDTO);
	}
}
