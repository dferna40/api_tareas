package com.david.api_tareas.dto.input;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Genera getters, setters, equals, hashCode y toString automáticamente
@NoArgsConstructor // Genera constructor sin argumentos
@AllArgsConstructor // Genera constructor con todos los campos
@Builder // Permite construir objetos con el patrón builder
public class UsuarioInputDTO {

	@NotBlank(message = "El nombre es obligatorio") // El nombre no puede ser nulo ni estar en blanco
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres") // Longitud mínima y máxima
    private String nombre;

    
    private Long puestoId;

    @NotBlank(message = "La contraseña es obligatoria") // La contraseña es obligatoria (puedes añadir validaciones de fuerza si lo deseas)
    private String password;
    
    @NotBlank(message = "El correo es obligatorio") // El email no puede estar en blanco
    @Email(message = "Debe ser un correo electrónico válido") // Valida que tenga formato de email
    private String email;
}
