package com.apirest.gestiondeinventario_backend.empleado.application.mapper;

import org.springframework.stereotype.Component;

import com.apirest.gestiondeinventario_backend.common.application.IEntityDtoMapper;
import com.apirest.gestiondeinventario_backend.empleado.application.dto.request.EliminarEmpleadoRequestDto;
import com.apirest.gestiondeinventario_backend.empleado.application.dto.response.EliminarEmpleadoResponseDto;
import com.apirest.gestiondeinventario_backend.empleado.domain.entities.Empleado;

@Component
public class EliminarEmpleadoMapper implements IEntityDtoMapper<Empleado, EliminarEmpleadoRequestDto, EliminarEmpleadoResponseDto>{

    @Override
    public Empleado requestToEntity(EliminarEmpleadoRequestDto requestDto) {
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(requestDto.getIdEmpleado());
        empleado.setEsDesactivado(0);
        return empleado;
    }

    @Override
    public EliminarEmpleadoResponseDto entityToResponse(Empleado entity) {
        EliminarEmpleadoResponseDto responseDto = new EliminarEmpleadoResponseDto();
        responseDto.setIdEmpleado(entity.getIdEmpleado());
        return responseDto;
    }
    
}
