package com.david.api_tareas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.david.api_tareas.dto.output.TareaOutputDTO;
import com.david.api_tareas.model.Tarea;


public interface TareaService {

    public List<Tarea> listarTodas();
    
    public List<TareaOutputDTO> listarTodasDTO();

    public Tarea guardar(Tarea tarea);

    public Optional<Tarea> buscarPorId(Long id);

    public void eliminar(Long id);
    
    public List<TareaOutputDTO> obtenerTareasPorUsuario(Long usuarioId);
    
    public List<TareaOutputDTO> obtenerTareasPorEstado(Long estadoId);
    
    List<TareaOutputDTO> buscarPorTexto(String texto);
    
    List<TareaOutputDTO> buscarPorUsuarioYEstado(Long usuarioId, Long estadoId);
    
    Page<TareaOutputDTO> listarPaginadas(Pageable pageable);
}
