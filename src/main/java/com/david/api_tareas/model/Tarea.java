package com.david.api_tareas.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Entidad que representa las tareas") // Documentación para Swagger
@Entity // Marca esta clase como una entidad JPA
@Table(name = "tareas") // Nombre de la tabla en la base de datos
@EntityListeners(AuditingEntityListener.class) // Habilita las anotaciones de auditoría
@Data // Genera automáticamente getters, setters, equals, hashCode y toString
@NoArgsConstructor // Constructor sin argumentos
@AllArgsConstructor // Constructor con todos los argumentos
@Builder // Permite construir objetos con patrón builder
public class Tarea {

    @Id // Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática del ID
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    private String titulo; // Título de la tarea
    private String descripcion; // Descripción detallada de la tarea
    private boolean completada; // Indicador de si la tarea está finalizada

    @CreatedDate // Fecha de creación automática (requiere @EnableJpaAuditing)
    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @LastModifiedDate // Fecha de modificación automática
    @Column(nullable = false)
    private LocalDateTime fechaModificacion;

    // ✅ Relación con el usuario que creó o es responsable de la tarea
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // ✅ Relación con el estado actual de la tarea
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "estado_id", nullable = false)
    private EstadoTarea estadoTarea;

    // ✅ Campos opcionales para acceder directamente a los IDs sin cargar los objetos completos
    @Column(name = "usuario_id", insertable = false, updatable = false)
    private Long usuarioId;

    @Column(name = "estado_id", insertable = false, updatable = false)
    private Long estadoTareaId;
}
