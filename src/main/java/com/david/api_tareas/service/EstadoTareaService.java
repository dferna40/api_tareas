package com.david.api_tareas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.api_tareas.model.EstadoTarea;
import com.david.api_tareas.repository.EstadoTareaRepository;

@Service
public class EstadoTareaService {

	@Autowired
    private EstadoTareaRepository estadoTarea;
	
	public List<EstadoTarea> listarTodas() {
		return estadoTarea.findAll();
	}
}
