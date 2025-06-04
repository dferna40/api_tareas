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

@RestController // Marca esta clase como un controlador REST
@RequestMapping("/tareas") // Ruta base: /tareas
@Tag(name = "Tareas", description = "Operaciones relacionadas con las tareas") // Documentación para Swagger
public class TareaController {

    @Autowired
    private TareaService tareaService; // Servicio que contiene la lógica de negocio relacionada con las tareas

    @GetMapping
    @Operation(summary = "Listar tareas") // Listar todas las tareas sin filtros
    public ResponseEntity<List<TareaOutputDTO>> listar() {
        return ResponseEntity.ok(tareaService.listarTodasDTO());
    }

    @PostMapping
    @Operation(summary = "Crear tarea") // Crear una nueva tarea
    public ResponseEntity<TareaOutputDTO> crear(@Valid @RequestBody TareaInputDTO dto) {
        TareaOutputDTO nuevaTarea = tareaService.guardar(dto);
        return ResponseEntity.ok(nuevaTarea);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una tarea por ID") // Buscar una tarea concreta por su ID
    public ResponseEntity<TareaOutputDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(tareaService.obtenerTareaPorId(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar tarea") // Eliminar una tarea por su ID
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        tareaService.eliminar(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    @GetMapping("/usuario/{id}")
    @Operation(summary = "Obtener las tareas del usuario") // Buscar tareas por ID de usuario
    public ResponseEntity<List<TareaOutputDTO>> getTareasPorUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(tareaService.obtenerTareasPorUsuario(id));
    }

    @GetMapping("/estado/{id}")
    @Operation(summary = "Obtener las tareas con un estado determinado") // Buscar tareas por ID de estado
    public ResponseEntity<List<TareaOutputDTO>> getTareasPorEstado(@PathVariable Long id) {
        return ResponseEntity.ok(tareaService.obtenerTareasPorEstado(id));
    }

    @GetMapping("/buscar")
    @Operation(summary = "Buscar tareas por texto") // Buscar tareas que contengan texto en el título o descripción
    public ResponseEntity<List<TareaOutputDTO>> buscarTareasPorTexto(@RequestParam String texto) {
        return ResponseEntity.ok(tareaService.buscarPorTexto(texto));
    }

    @GetMapping("/filtro")
    @Operation(summary = "Buscar tareas por usuario y estado") // Buscar tareas combinando filtros: usuario y estado
    public ResponseEntity<List<TareaOutputDTO>> buscarPorUsuarioYEstado(
            @RequestParam Long usuarioId,
            @RequestParam Long estadoId) {
        return ResponseEntity.ok(tareaService.buscarPorUsuarioYEstado(usuarioId, estadoId));
    }

    @GetMapping("/paginadas")
    @Operation(summary = "Listar tareas paginadas") // Listado de tareas paginado (útil para mostrar en frontend por páginas)
    public ResponseEntity<Page<TareaOutputDTO>> listarPaginadas(Pageable pageable) {
        return ResponseEntity.ok(tareaService.listarPaginadas(pageable));
    }
    
    @GetMapping("/mis-tareas")
    public ResponseEntity<?> getTareasDelUsuario(Authentication authentication) {
        // Obtiene el nombre de usuario del token JWT
        String username = authentication.getName();
        return ResponseEntity.ok("Hola, " + username);
    }

}
