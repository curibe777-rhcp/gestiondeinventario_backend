package com.apirest.gestiondeinventario_backend.proveedor.application.mapper;

import org.springframework.stereotype.Component;

import com.apirest.gestiondeinventario_backend.common.application.IEntityDtoMapper;
import com.apirest.gestiondeinventario_backend.proveedor.application.dto.request.EliminarProveedorRequestDto;
import com.apirest.gestiondeinventario_backend.proveedor.application.dto.response.EliminarProveedorResponseDto;
import com.apirest.gestiondeinventario_backend.proveedor.domain.entities.Proveedor;

@Component
public class EliminarProveedorMapper implements IEntityDtoMapper<Proveedor, EliminarProveedorRequestDto, EliminarProveedorResponseDto> {

    @Override
    public Proveedor requestToEntity(EliminarProveedorRequestDto requestDto) {
        Proveedor proveedor = new Proveedor();
        proveedor.setIdProveedor(requestDto.getIdProveedor());
        proveedor.setEsDesactivado(0);
        return proveedor;
    }

    @Override
    public EliminarProveedorResponseDto entityToResponse(Proveedor entity) {
        EliminarProveedorResponseDto responseDto = new EliminarProveedorResponseDto();
        responseDto.setIdProveedor(entity.getIdProveedor());
        return responseDto;
    }
}
