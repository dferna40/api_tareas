package com.david.api_tareas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.api_tareas.dto.input.UsuarioInputDTO;
import com.david.api_tareas.dto.output.UsuarioOutputDTO;
import com.david.api_tareas.mapper.UsuarioMapper;
import com.david.api_tareas.model.Usuario;
import com.david.api_tareas.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
    private  UsuarioRepository usuarioRepository;
	
	public List<UsuarioOutputDTO> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioMapper::toDTO)
                .collect(Collectors.toList());
    }
	
	public UsuarioOutputDTO crearUsuario(UsuarioInputDTO dto) {
        Usuario usuario = UsuarioMapper.toEntity(dto);
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return UsuarioMapper.toDTO(usuarioGuardado);
    }
	
	public List<UsuarioOutputDTO> obtenerTodosLosUsuarios() {
	    List<Usuario> usuarios = usuarioRepository.findAll();
	    return usuarios.stream()
	                   .map(UsuarioMapper::toDTO)
	                   .collect(Collectors.toList());
	}
}
