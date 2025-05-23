package com.david.api_tareas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.api_tareas.dto.output.TareaOutputDTO;
import com.david.api_tareas.mapper.TareaMapper;
import com.david.api_tareas.model.Tarea;
import com.david.api_tareas.repository.TareaRepository;

@Service
public class TareaService {

	@Autowired
    private TareaRepository tareaRepository;

    public List<Tarea> listarTodas() {
        return tareaRepository.findAll();
    }

    public Tarea guardar(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public Optional<Tarea> buscarPorId(Long id) {
        return tareaRepository.findById(id);
    }

    public void eliminar(Long id) {
        tareaRepository.deleteById(id);
    }
    
    public List<TareaOutputDTO> obtenerTareasPorUsuario(Long usuarioId) {
        List<Tarea> tareas = tareaRepository.findByUsuarioId(usuarioId);
        return tareas.stream()
                     .map(TareaMapper::toDTO)
                     .collect(Collectors.toList());
    }
}
