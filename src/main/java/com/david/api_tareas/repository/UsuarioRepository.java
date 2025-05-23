package com.david.api_tareas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.david.api_tareas.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
