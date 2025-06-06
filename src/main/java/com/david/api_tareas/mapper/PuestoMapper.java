package com.david.api_tareas.mapper;

import com.david.api_tareas.dto.output.PuestoOutputDTO;
import com.david.api_tareas.model.Puesto;

public class PuestoMapper {

    public static PuestoOutputDTO toDTO(Puesto puesto) {
        PuestoOutputDTO dto = new PuestoOutputDTO();
        dto.setId(puesto.getId());
        dto.setNombre(puesto.getNombre());
        return dto;
    }
}
