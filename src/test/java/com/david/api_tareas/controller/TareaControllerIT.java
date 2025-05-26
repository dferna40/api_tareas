package com.david.api_tareas.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.david.api_tareas.model.EstadoTarea;
import com.david.api_tareas.model.Tarea;
import com.david.api_tareas.model.Usuario;
import com.david.api_tareas.repository.EstadoTareaRepository;
import com.david.api_tareas.repository.TareaRepository;
import com.david.api_tareas.repository.UsuarioRepository;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
class TareaControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EstadoTareaRepository estadoTareaRepository;
    
    private EstadoTarea estado;

    @BeforeEach
    void setUp() {
        tareaRepository.deleteAll();
        usuarioRepository.deleteAll();
        estadoTareaRepository.deleteAll();

        Usuario usuario = new Usuario();
        usuario.setNombre("David");
        usuario = usuarioRepository.save(usuario);

        estado = new EstadoTarea();
        estado.setNombreDelEstado("Pendiente");
        estado = estadoTareaRepository.save(estado);

        Tarea tarea = new Tarea();
        tarea.setTitulo("Prueba");
        tarea.setDescripcion("Tarea de prueba");
        tarea.setUsuario(usuario);
        tarea.setEstadoTarea(estado);
        tareaRepository.save(tarea);
    }


    @Test
    void deberiaListarTareasCorrectamente() throws Exception {
        mockMvc.perform(get("/api/tareas")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].titulo").value("Prueba"))
            .andExpect(jsonPath("$[0].descripcion").value("Tarea de prueba"));
    }
    
    @Test
    void deberiaCrearTareaCorrectamente() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNombre("David");
        usuario = usuarioRepository.save(usuario);

        String tareaJson = """
            {
                "titulo": "Nueva tarea",
                "descripcion": "Descripción desde el test",
                "idUsuario": %d,
                "idEstadoTarea": %d
            }
            """.formatted(usuario.getId(), estado.getId()); // 🔁 usar estado ya guardado

        mockMvc.perform(post("/api/tareas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(tareaJson))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.titulo").value("Nueva tarea"))
            .andExpect(jsonPath("$.descripcion").value("Descripción desde el test"));
    }


}

