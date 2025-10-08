package com.apirest.gestiondeinventario_backend.empleado.application.mapper;

import org.springframework.stereotype.Component;

import com.apirest.gestiondeinventario_backend.common.application.IEntityDtoMapper;
import com.apirest.gestiondeinventario_backend.empleado.application.dto.request.InsertarEmpleadoRequestDto;
import com.apirest.gestiondeinventario_backend.empleado.application.dto.response.InsertarEmpleadoResponseDto;
import com.apirest.gestiondeinventario_backend.empleado.domain.entities.Empleado;

@Component
public class InsertarEmpleadoMapper implements IEntityDtoMapper<Empleado, InsertarEmpleadoRequestDto, InsertarEmpleadoResponseDto> {

    @Override
    public Empleado requestToEntity(InsertarEmpleadoRequestDto requestDto) {
        Empleado empleado = new Empleado();
        empleado.setNombre(requestDto.getNombre());
        empleado.setApellidoPaterno(requestDto.getApellidoPaterno());
        empleado.setApellidoMaterno(requestDto.getApellidoMaterno());
        empleado.setFechaNacimiento(requestDto.getFechaNacimiento());
        empleado.setTipoDocumento(requestDto.getTipoDocumento());
        empleado.setNumeroDocumento(requestDto.getNumeroDocumento());
        empleado.setGenero(requestDto.getGenero());
        empleado.setEstadoCivil(requestDto.getEstadoCivil());
        empleado.setDireccion(requestDto.getDireccion());
        empleado.setDistrito(requestDto.getDistrito());
        return empleado;
    }

    @Override
    public InsertarEmpleadoResponseDto entityToResponse(Empleado entity) {
        InsertarEmpleadoResponseDto responseDto = new InsertarEmpleadoResponseDto();
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
