package com.david.api_tareas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
