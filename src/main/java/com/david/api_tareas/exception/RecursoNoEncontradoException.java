package com.david.api_tareas.exception;

// Excepción personalizada para representar errores de tipo "404 - Not Found"
public class RecursoNoEncontradoException extends RuntimeException {

    // Constructor que recibe un mensaje personalizado de error
    public RecursoNoEncontradoException(String mensaje) {
        super(mensaje); // Llama al constructor de la clase RuntimeException
    }
}
