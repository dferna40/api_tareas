package com.david.api_tareas.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.swagger.v3.oas.annotations.Hidden;

@Hidden // Oculta esta clase del listado de Swagger/OpenAPI
@RestControllerAdvice // Permite manejar excepciones globalmente para todos los controladores REST
public class GlobalExceptionHandler {

    // Maneja excepciones de validación (por ejemplo, DTOs con campos inválidos)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, Object> response = new HashMap<>();
        Map<String, String> errores = new HashMap<>();

        // Extrae los errores campo a campo del resultado de la validación
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errores.put(error.getField(), error.getDefaultMessage());
        });

        // Estructura personalizada de respuesta
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.BAD_REQUEST.value()); // 400 Bad Request
        response.put("errores", errores); // Lista de errores campo -> mensaje

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // Maneja cualquier otra excepción no controlada
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value()); // 500 Internal Server Error
        response.put("error", ex.getMessage()); // Mensaje general de error
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
