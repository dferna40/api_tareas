package com.david.api_tareas.model;

import java.time.LocalDateTime;
import java.util.List;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Entidad que representa un estado posible de una tarea") // Documentación para Swagger
@Entity // Marca esta clase como una entidad JPA
@Table(name = "estados_tarea") // Nombre de la tabla en la base de datos
@EntityListeners(AuditingEntityListener.class) // Permite usar @CreatedDate y @LastModifiedDate
@Data // Genera automáticamente getters, setters, equals, hashCode y toString
@NoArgsConstructor // Constructor sin argumentos
@AllArgsConstructor // Constructor con todos los argumentos
@Builder // Soporte para patrón builder
public class EstadoTarea {

    // Constructor adicional para crear un estado con solo el nombre (útil en inicializaciones rápidas)
    public EstadoTarea(String nombre) {
		this.nombreDelEstado = nombre;
	}

	@Id // Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    private Long id;

    private String nombreDelEstado; // Nombre legible del estado (por ejemplo, "Por hacer")

    @CreatedDate // Se establece automáticamente al crear la entidad
    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @LastModifiedDate // Se actualiza automáticamente cuando la entidad se modifica
    @Column(nullable = false)
    private LocalDateTime fechaModificacion;

    // 👇 Relación uno a muchos: un estado puede tener muchas tareas
    // `mappedBy = "estadoTarea"` indica que el campo está definido en la entidad Tarea
    // `LAZY` evita cargar las tareas asociadas automáticamente (mejor rendimiento)
    @OneToMany(mappedBy = "estadoTarea", fetch = FetchType.LAZY)
    private List<Tarea> tareas;
}
