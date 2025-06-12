package com.david.api_tareas.controller;

import com.david.api_tareas.dto.output.PuestoOutputDTO;
import com.david.api_tareas.service.PuestoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/puestos")
@RequiredArgsConstructor
public class PuestoController {

    private final PuestoService puestoService;

    @GetMapping
    public ResponseEntity<List<PuestoOutputDTO>> listarPuestos() {
        return ResponseEntity.ok(puestoService.obtenerTodos());
    }
}
