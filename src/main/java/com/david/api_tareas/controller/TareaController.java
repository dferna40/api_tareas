package com.david.api_tareas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.david.api_tareas.dto.input.TareaInputDTO;
import com.david.api_tareas.dto.output.TareaOutputDTO;
import com.david.api_tareas.mapper.TareaMapper;
import com.david.api_tareas.model.EstadoTarea;
import com.david.api_tareas.model.Tarea;
import com.david.api_tareas.model.Usuario;
import com.david.api_tareas.repository.EstadoTareaRepository;
import com.david.api_tareas.repository.UsuarioRepository;
import com.david.api_tareas.service.TareaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tareas")
@Tag(name = "Tareas", description = "Operaciones relacionadas con las tareas")
public class TareaController {

	@Autowired
    private TareaService tareaService;
	
	@Autowired
	private EstadoTareaRepository estadoTareaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	@Operation(summary = "Listar tareas")
	public List<TareaOutputDTO> listar() {
	    return tareaService.listarTodasDTO();
	}

    @PostMapping
    @Operation(summary = "Crear tarea")
    public TareaOutputDTO crear(@Valid @RequestBody TareaInputDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        EstadoTarea estado = estadoTareaRepository.findById(dto.getIdEstadoTarea())
            .orElseThrow(() -> new RuntimeException("Estado de tarea no encontrado"));

        Tarea tarea = TareaMapper.toEntity(dto, usuario, estado);
        Tarea tareaGuardada = tareaService.guardar(tarea);

        return TareaMapper.toDTO(tareaGuardada);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una tarea por ID")
    public ResponseEntity<TareaOutputDTO> obtener(@PathVariable Long id) {
        return tareaService.buscarPorId(id)
            .map(tarea -> ResponseEntity.ok(TareaMapper.toDTO(tarea)))
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar tarea")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        tareaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/tareas/usuario/{id}")
    @Operation(summary = "Obtener las tareas del usuario")
    public ResponseEntity<List<TareaOutputDTO>> getTareasPorUsuario(@PathVariable Long id) {
        List<TareaOutputDTO> tareas = tareaService.obtenerTareasPorUsuario(id);
        return ResponseEntity.ok(tareas);
    }
    
    @GetMapping("/tareas/estado/{id}")
    @Operation(summary = "Obtener las tareas con un estado determinado")
    public ResponseEntity<List<TareaOutputDTO>> getTareasPorEstado(@PathVariable Long id) {
        List<TareaOutputDTO> tareas = tareaService.obtenerTareasPorEstado(id);
        return ResponseEntity.ok(tareas);
    }

    @GetMapping("/buscar")
    @Operation(summary = "Buscar tareas por texto")
    public ResponseEntity<List<TareaOutputDTO>> buscarTareasPorTexto(@RequestParam String texto) {
        List<TareaOutputDTO> resultados = tareaService.buscarPorTexto(texto);
        return ResponseEntity.ok(resultados);
    }
    
    @GetMapping("/filtro")
    @Operation(summary = "Buscar tareas por usuario y estado")
    public ResponseEntity<List<TareaOutputDTO>> buscarPorUsuarioYEstado(
            @RequestParam Long usuarioId,
            @RequestParam Long estadoId) {
        
        List<TareaOutputDTO> resultados = tareaService.buscarPorUsuarioYEstado(usuarioId, estadoId);
        return ResponseEntity.ok(resultados);
    }
    
    @GetMapping("/paginadas")
    @Operation(summary = "Listar tareas paginadas")
    public ResponseEntity<Page<TareaOutputDTO>> listarPaginadas(Pageable pageable) {
        Page<TareaOutputDTO> tareas = tareaService.listarPaginadas(pageable);
        return ResponseEntity.ok(tareas);
    }
}
