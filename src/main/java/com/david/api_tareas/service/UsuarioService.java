package com.david.api_tareas.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.david.api_tareas.dto.input.UsuarioInputDTO;
import com.david.api_tareas.dto.output.UsuarioOutputDTO;
import com.david.api_tareas.mapper.UsuarioMapper;
import com.david.api_tareas.model.Puesto;
import com.david.api_tareas.model.Usuario;
import com.david.api_tareas.repository.PuestoRepository;
import com.david.api_tareas.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service // Indica que esta clase es un componente de servicio de Spring
@RequiredArgsConstructor // Lombok: genera constructor con los campos final (inyección implícita)
public class UsuarioService {

	// Inyecciones a través del constructor gracias a @RequiredArgsConstructor
	private final UsuarioRepository usuarioRepository;
	// private final PasswordEncoder passwordEncoder;
	private final PuestoRepository puestoRepository;

	public List<UsuarioOutputDTO> obtenerTodosLosUsuarios() {
		return usuarioRepository.findAll().stream().map(UsuarioMapper::toDTO).collect(Collectors.toList());
	}

	public UsuarioOutputDTO crearPerfilUsuario(UsuarioInputDTO dto) {
		System.out.println("📨 Email recibido: " + dto.getEmail());
		System.out.println("📌 puestoId recibido: " + dto.getPuestoId());

		Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(dto.getEmail());

		if (usuarioExistente.isPresent()) {
			Usuario u = usuarioExistente.get();

			if (u.getPuesto() != null) {
				System.out.println("⚠ El perfil ya existe con puesto asignado.");
				throw new RuntimeException("El perfil ya existe");
			}

			// Asignar el puesto si el usuario existe pero no tiene perfil completo
			Puesto puesto = puestoRepository.findById(dto.getPuestoId())
					.orElseThrow(() -> new RuntimeException("Puesto no encontrado"));

			u.setPuesto(puesto);
			u.setFechaModificacion(LocalDateTime.now());

			Usuario actualizado = usuarioRepository.save(u);
			System.out.println("📝 Perfil completado para usuario existente.");
			return UsuarioMapper.toDTO(actualizado);
		}

		// Crear nuevo usuario si no existía en api-tareas
		Usuario nuevo = new Usuario();
		nuevo.setNombre(dto.getNombre());
		nuevo.setEmail(dto.getEmail());
		nuevo.setFechaCreacion(LocalDateTime.now());
		nuevo.setFechaModificacion(LocalDateTime.now());

		Puesto puesto = puestoRepository.findById(dto.getPuestoId())
				.orElseThrow(() -> new RuntimeException("Puesto no encontrado"));

		nuevo.setPuesto(puesto);

		Usuario guardado = usuarioRepository.save(nuevo);
		System.out.println("✅ Nuevo usuario creado con perfil.");
		return UsuarioMapper.toDTO(guardado);
	}

}
