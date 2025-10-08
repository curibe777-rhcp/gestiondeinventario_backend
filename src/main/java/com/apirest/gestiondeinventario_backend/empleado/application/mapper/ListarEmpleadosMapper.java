package com.apirest.gestiondeinventario_backend.empleado.application.mapper;

import org.springframework.stereotype.Component;

import com.apirest.gestiondeinventario_backend.common.application.IEntityDtoMapper;
import com.apirest.gestiondeinventario_backend.empleado.application.dto.request.ListarEmpleadosRequestDto;
import com.apirest.gestiondeinventario_backend.empleado.application.dto.response.ListarEmpleadosResponseDto;
import com.apirest.gestiondeinventario_backend.empleado.domain.entities.Empleado;

@Component
public class ListarEmpleadosMapper implements IEntityDtoMapper<Empleado, ListarEmpleadosRequestDto, ListarEmpleadosResponseDto> {

    @Override
    public Empleado requestToEntity(ListarEmpleadosRequestDto requestDto) {
        return null;
    }

    @Override
    public ListarEmpleadosResponseDto entityToResponse(Empleado entity) {
        ListarEmpleadosResponseDto responseDto = new ListarEmpleadosResponseDto();
        responseDto.setNombre(entity.getNombre());
        responseDto.setApellidoPaterno(entity.getApellidoPaterno());
        responseDto.setApellidoMaterno(entity.getApellidoMaterno());
        responseDto.setFechaNacimiento(entity.getFechaNacimiento());
        responseDto.setTipoDocumento(entity.getTipoDocumento());
        responseDto.setNumeroDocumento(entity.getNumeroDocumento());
        responseDto.setGenero(entity.getGenero());
        responseDto.setEstadoCivil(entity.getEstadoCivil());
        responseDto.setDireccion(entity.getDireccion());
        responseDto.setDistrito(entity.getDistrito());
        responseDto.setIdEmpleado(entity.getIdEmpleado());
        return responseDto;
    }
    
}
