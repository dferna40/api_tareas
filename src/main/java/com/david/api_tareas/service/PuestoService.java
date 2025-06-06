package com.david.api_tareas.service;

import com.david.api_tareas.dto.output.PuestoOutputDTO;
import com.david.api_tareas.mapper.PuestoMapper;
import com.david.api_tareas.repository.PuestoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PuestoService {

    private final PuestoRepository puestoRepository;

    public List<PuestoOutputDTO> obtenerTodos() {
        return puestoRepository.findAll()
                .stream()
                .map(PuestoMapper::toDTO)
                .collect(Collectors.toList());
    }
}

