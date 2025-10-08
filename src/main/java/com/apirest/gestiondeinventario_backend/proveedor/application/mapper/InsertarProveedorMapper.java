package com.apirest.gestiondeinventario_backend.proveedor.application.mapper;

import org.springframework.stereotype.Component;

import com.apirest.gestiondeinventario_backend.common.application.IEntityDtoMapper;
import com.apirest.gestiondeinventario_backend.proveedor.application.dto.request.InsertarProveedorRequestDto;
import com.apirest.gestiondeinventario_backend.proveedor.application.dto.response.InsertarProveedorResponseDto;
import com.apirest.gestiondeinventario_backend.proveedor.domain.entities.Proveedor;

@Component
public class InsertarProveedorMapper implements IEntityDtoMapper<Proveedor, InsertarProveedorRequestDto, InsertarProveedorResponseDto> {

    @Override
    public Proveedor requestToEntity(InsertarProveedorRequestDto requestDto) {
        Proveedor proveedor = new Proveedor();
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
    public InsertarProveedorResponseDto entityToResponse(Proveedor entity) {
        InsertarProveedorResponseDto responseDto = new InsertarProveedorResponseDto();
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
