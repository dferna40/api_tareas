package com.david.api_tareas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.api_tareas.dto.output.TareaOutputDTO;
import com.david.api_tareas.model.Tarea;
import com.david.api_tareas.service.TareaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/tareas")
@Tag(name = "Tareas", description = "Operaciones relacionadas con las tareas")
public class TareaController {

	@Autowired
    private TareaService tareaService;

    @GetMapping
    @Operation(summary = "Listar tareas")
    public List<Tarea> listar() {
        return tareaService.listarTodas();
    }

    @PostMapping
    @Operation(summary = "Crear tarea")
    public Tarea crear(@RequestBody Tarea tarea) {
        return tareaService.guardar(tarea);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una tarea por ID")
    public ResponseEntity<Tarea> obtener(@PathVariable Long id) {
        return tareaService.buscarPorId(id)
            .map(ResponseEntity::ok)
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
}
