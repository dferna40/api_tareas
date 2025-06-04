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

@Service // Marca esta clase como un servicio de Spring (gestiona lógica de negocio)
public class TareaService {

	@Autowired
	private TareaRepository tareaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private EstadoTareaRepository estadoTareaRepository;

	// Devuelve todas las tareas en forma de DTOs
	public List<TareaOutputDTO> obtenerTodasLasTareas() {
		return tareaRepository.findAll().stream().map(TareaMapper::toDTO).toList();
	}

	// Guarda una nueva tarea a partir de un DTO de entrada
	public TareaOutputDTO guardar(TareaInputDTO dto) {
		// Validación básica de IDs requeridos
		if (dto.getUsuarioId() == null || dto.getEstadoTareaId() == null) {
			throw new IllegalArgumentException("El usuarioId y estadoTareaId son obligatorios.");
		}

		// Buscar usuario por ID o lanzar excepción si no existe
		Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

		// Buscar estado por ID o lanzar excepción si no existe
		EstadoTarea estado = estadoTareaRepository.findById(dto.getEstadoTareaId())
				.orElseThrow(() -> new RuntimeException("Estado no encontrado"));

		// Convertir DTO a entidad, guardar y convertir el resultado a DTO de salida
		Tarea tarea = TareaMapper.toEntity(dto, usuario, estado);
		Tarea tareaGuardada = tareaRepository.save(tarea);

		return TareaMapper.toDTO(tareaGuardada);
	}

	// Devuelve una tarea por ID como DTO, o lanza excepción si no existe
	public TareaOutputDTO obtenerTareaPorId(Long id) {
		Tarea tarea = tareaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Tarea no encontrada con id: " + id));
		return TareaMapper.toDTO(tarea);
	}

	// Elimina una tarea por su ID
	public void eliminar(Long id) {
		tareaRepository.deleteById(id);
	}

	// Devuelve las tareas de un usuario específico (por ID)
	public List<TareaOutputDTO> obtenerTareasPorUsuario(Long usuarioId) {
		List<Tarea> tareas = tareaRepository.findByUsuarioId(usuarioId);
		return tareas.stream().map(TareaMapper::toDTO).collect(Collectors.toList());
	}

	// Devuelve las tareas que tienen un estado específico
	public List<TareaOutputDTO> obtenerTareasPorEstado(Long estadoId) {
		List<Tarea> tareas = tareaRepository.findByEstadoTareaId(estadoId);
		return tareas.stream().map(TareaMapper::toDTO).collect(Collectors.toList());
	}

	// Versión alternativa para listar todas las tareas
	public List<TareaOutputDTO> listarTodasDTO() {
		return tareaRepository.findAll().stream().map(TareaMapper::toDTO).collect(Collectors.toList());
	}

	// Buscar tareas por texto parcial (en título o descripción)
	public List<TareaOutputDTO> buscarPorTexto(String texto) {
		List<Tarea> tareas = tareaRepository.buscarPorTexto(texto);
		return tareas.stream().map(TareaMapper::toDTO).collect(Collectors.toList());
	}

	// Buscar tareas por combinación de usuario y estado
	public List<TareaOutputDTO> buscarPorUsuarioYEstado(Long usuarioId, Long estadoId) {
		List<Tarea> tareas = tareaRepository.findByUsuarioIdAndEstadoTareaId(usuarioId, estadoId);
		return tareas.stream().map(TareaMapper::toDTO).collect(Collectors.toList());
	}

	// Listar tareas en formato paginado (útil para tablas o scroll infinito)
	public Page<TareaOutputDTO> listarPaginadas(Pageable pageable) {
		return tareaRepository.findAll(pageable).map(TareaMapper::toDTO);
	}
}
