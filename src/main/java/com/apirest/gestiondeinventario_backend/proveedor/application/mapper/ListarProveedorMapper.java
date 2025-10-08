package com.apirest.gestiondeinventario_backend.proveedor.application.mapper;

import org.springframework.stereotype.Component;

import com.apirest.gestiondeinventario_backend.common.application.IEntityDtoMapper;
import com.apirest.gestiondeinventario_backend.proveedor.application.dto.request.ListarProveedorRequestDto;
import com.apirest.gestiondeinventario_backend.proveedor.application.dto.response.ListarProveedorResponseDto;
import com.apirest.gestiondeinventario_backend.proveedor.domain.entities.Proveedor;

@Component
public class ListarProveedorMapper implements IEntityDtoMapper<Proveedor, ListarProveedorRequestDto, ListarProveedorResponseDto> {
    @Override
    public Proveedor requestToEntity(ListarProveedorRequestDto requestDto) {
        return null;
    }

    @Override
    public ListarProveedorResponseDto entityToResponse(Proveedor entity) {
        ListarProveedorResponseDto responseDto = new ListarProveedorResponseDto();
        responseDto.setIdProveedor(entity.getIdProveedor());
        responseDto.setTipoDocumento(entity.getTipoDocumento());
        responseDto.setNumeroDocumento(entity.getNumeroDocumento());
        responseDto.setRazonSocial(entity.getRazonSocial());
        responseDto.setNombreComercial(entity.getNombreComercial());
        responseDto.setContacto(entity.getContacto());
        responseDto.setTelefono(entity.getTelefono());
        responseDto.setDireccion(entity.getDireccion());
        responseDto.setDistrito(entity.getDistrito());
        return responseDto;
    }
}
