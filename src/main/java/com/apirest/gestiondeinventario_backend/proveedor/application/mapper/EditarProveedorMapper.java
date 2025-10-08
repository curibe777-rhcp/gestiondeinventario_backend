package com.apirest.gestiondeinventario_backend.proveedor.application.mapper;

import org.springframework.stereotype.Component;

import com.apirest.gestiondeinventario_backend.common.application.IEntityDtoMapper;
import com.apirest.gestiondeinventario_backend.proveedor.application.dto.request.EditarProveedorRequestDto;
import com.apirest.gestiondeinventario_backend.proveedor.application.dto.response.EditarProveedorResponseDto;
import com.apirest.gestiondeinventario_backend.proveedor.domain.entities.Proveedor;

@Component
public class EditarProveedorMapper implements IEntityDtoMapper<Proveedor, EditarProveedorRequestDto, EditarProveedorResponseDto> {

    @Override
    public Proveedor requestToEntity(EditarProveedorRequestDto requestDto) {
        Proveedor proveedor = new Proveedor();
        proveedor.setIdProveedor(requestDto.getIdProveedor());
        proveedor.setTipoDocumento(requestDto.getTipoDocumento());
        proveedor.setNumeroDocumento(requestDto.getNumeroDocumento());
        proveedor.setRazonSocial(requestDto.getRazonSocial());
        proveedor.setNombreComercial(requestDto.getNombreComercial());
        proveedor.setContacto(requestDto.getContacto());
        proveedor.setTelefono(requestDto.getTelefono());
        proveedor.setDireccion(requestDto.getDireccion());
        proveedor.setDistrito(requestDto.getDistrito());
        return proveedor;
    }

    @Override
    public EditarProveedorResponseDto entityToResponse(Proveedor entity) {
        EditarProveedorResponseDto responseDto = new EditarProveedorResponseDto();
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
