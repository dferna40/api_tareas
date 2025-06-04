package com.david.api_tareas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.david.api_tareas.dto.input.TareaInputDTO;
import com.david.api_tareas.dto.output.TareaOutputDTO;
import com.david.api_tareas.service.TareaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tareas")
@Tag(name = "Tareas", description = "Operaciones relacionadas con las tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping
    @Operation(summary = "Listar tareas")
    public ResponseEntity<List<TareaOutputDTO>> listar() {
        return ResponseEntity.ok(tareaService.listarTodasDTO());
    }

    @PostMapping
    @Operation(summary = "Crear tarea")
    public ResponseEntity<TareaOutputDTO> crear(@Valid @RequestBody TareaInputDTO dto) {
        TareaOutputDTO nuevaTarea = tareaService.guardar(dto);
        return ResponseEntity.ok(nuevaTarea);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una tarea por ID")
    public ResponseEntity<TareaOutputDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(tareaService.obtenerTareaPorId(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar tarea")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        tareaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/usuario/{id}")
    @Operation(summary = "Obtener las tareas del usuario")
    public ResponseEntity<List<TareaOutputDTO>> getTareasPorUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(tareaService.obtenerTareasPorUsuario(id));
    }

    @GetMapping("/estado/{id}")
    @Operation(summary = "Obtener las tareas con un estado determinado")
    public ResponseEntity<List<TareaOutputDTO>> getTareasPorEstado(@PathVariable Long id) {
        return ResponseEntity.ok(tareaService.obtenerTareasPorEstado(id));
    }

    @GetMapping("/buscar")
    @Operation(summary = "Buscar tareas por texto")
    public ResponseEntity<List<TareaOutputDTO>> buscarTareasPorTexto(@RequestParam String texto) {
        return ResponseEntity.ok(tareaService.buscarPorTexto(texto));
    }

    @GetMapping("/filtro")
    @Operation(summary = "Buscar tareas por usuario y estado")
    public ResponseEntity<List<TareaOutputDTO>> buscarPorUsuarioYEstado(
            @RequestParam Long usuarioId,
            @RequestParam Long estadoId) {
        return ResponseEntity.ok(tareaService.buscarPorUsuarioYEstado(usuarioId, estadoId));
    }

    @GetMapping("/paginadas")
    @Operation(summary = "Listar tareas paginadas")
    public ResponseEntity<Page<TareaOutputDTO>> listarPaginadas(Pageable pageable) {
        return ResponseEntity.ok(tareaService.listarPaginadas(pageable));
    }
    
    @GetMapping("/mis-tareas")
    public ResponseEntity<?> getTareasDelUsuario(Authentication authentication) {
        String username = authentication.getName(); // ← del token JWT
        return ResponseEntity.ok("Hola, " + username);
    }

}
