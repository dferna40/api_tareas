package com.david.api_tareas.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Schema(description = "Entidad que representa un usuario del sistema") // Documentación Swagger
@Entity // Indica que esta clase es una entidad JPA
@Table(name = "usuarios") // Nombre de la tabla en la base de datos
@EntityListeners(AuditingEntityListener.class) // Permite que se gestionen automáticamente las fechas de auditoría
@Data // Genera automáticamente getters, setters, equals, hashCode y toString
@NoArgsConstructor // Constructor sin argumentos
@AllArgsConstructor // Constructor con todos los argumentos
@Builder // Permite construir objetos con el patrón builder
public class Usuario {

    @Id // Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    private String nombre; // Nombre del usuario
    private String email; // Correo electrónico del usuario
    private String password; // Contraseña del usuario (⚠️ nunca devolver en los DTO de salida)
    @Column(nullable = false)
    private String role = "USER";

    @CreatedDate // Fecha de creación (autoasignada por Spring si se activa la auditoría)
    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @LastModifiedDate // Fecha de última modificación (autoasignada por Spring)
    @Column(nullable = false)
    private LocalDateTime fechaModificacion;

    // 👇 Relación uno a muchos: un usuario puede tener muchas tareas asociadas
    // mappedBy = "usuario" → indica el campo en la clase Tarea que representa esta relación
    // LAZY → no carga las tareas automáticamente (mejor rendimiento)
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Tarea> tareas;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "puesto_id")
    private Puesto puesto;
}
