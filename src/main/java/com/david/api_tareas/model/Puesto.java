package com.david.api_tareas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "puestos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Puesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;
    
    public Puesto(String nombre) {
        this.nombre = nombre;
    }

    // Opcional: si quieres ver usuarios desde el lado de Puesto
    // @OneToMany(mappedBy = "puesto")
    // private List<Usuario> usuarios;
}
