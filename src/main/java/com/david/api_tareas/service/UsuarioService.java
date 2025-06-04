package com.david.api_tareas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.david.api_tareas.dto.input.UsuarioInputDTO;
import com.david.api_tareas.dto.output.UsuarioOutputDTO;
import com.david.api_tareas.mapper.UsuarioMapper;
import com.david.api_tareas.model.Usuario;
import com.david.api_tareas.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service // Indica que esta clase es un componente de servicio de Spring
@RequiredArgsConstructor // Lombok: genera constructor con los campos final (inyección implícita)
public class UsuarioService {

    // Inyecciones a través del constructor gracias a @RequiredArgsConstructor
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    // Método para crear un nuevo usuario
    public UsuarioOutputDTO crearUsuario(UsuarioInputDTO dto) {
        // Convertimos el DTO de entrada a entidad
        Usuario usuario = UsuarioMapper.toEntity(dto);

        // Encriptamos la contraseña antes de guardarla
        String passwordEncriptado = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(passwordEncriptado);

        // Guardamos el usuario en la base de datos
        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        // Convertimos la entidad guardada a DTO de salida
        return UsuarioMapper.toDTO(usuarioGuardado);
    }

    // Método para obtener todos los usuarios como DTOs de salida
    public List<UsuarioOutputDTO> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioMapper::toDTO)
                .collect(Collectors.toList());
    }
}
