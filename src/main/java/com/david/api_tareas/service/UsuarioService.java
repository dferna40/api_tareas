package com.david.api_tareas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.david.api_tareas.dto.input.UsuarioInputDTO;
import com.david.api_tareas.dto.output.UsuarioOutputDTO;
import com.david.api_tareas.mapper.UsuarioMapper;
import com.david.api_tareas.model.Usuario;
import com.david.api_tareas.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;


    public UsuarioOutputDTO crearUsuario(UsuarioInputDTO dto) {
        Usuario usuario = UsuarioMapper.toEntity(dto);

        // Encriptar la contraseña
        String passwordEncriptado = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(passwordEncriptado);

        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return UsuarioMapper.toDTO(usuarioGuardado);
    }

    public List<UsuarioOutputDTO> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioMapper::toDTO)
                .collect(Collectors.toList());
    }
}
