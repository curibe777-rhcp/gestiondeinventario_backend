package com.apirest.gestiondeinventario_backend.producto.application.mapper;

import org.springframework.stereotype.Component;

import com.apirest.gestiondeinventario_backend.common.application.IEntityDtoMapper;
import com.apirest.gestiondeinventario_backend.producto.application.dto.request.InsertarProductoRequestDto;
import com.apirest.gestiondeinventario_backend.producto.application.dto.response.InsertarProductoResponseDto;
import com.apirest.gestiondeinventario_backend.producto.domain.entities.Producto;

@Component
public class InsertarProductoMapper implements IEntityDtoMapper<Producto, InsertarProductoRequestDto, InsertarProductoResponseDto>{

    @Override
    public Producto requestToEntity(InsertarProductoRequestDto requestDto) {
        
        Producto producto = new Producto();
        producto.setSku(requestDto.getSku());
        producto.setCodigoBarras(requestDto.getCodigoBarras());
        producto.setNombre(requestDto.getNombre());
        producto.setPrecioCosto(requestDto.getPrecioCosto());
        return producto;
    }

    @Override
    public InsertarProductoResponseDto entityToResponse(Producto entity) {
        InsertarProductoResponseDto responseDto = new InsertarProductoResponseDto();
        responseDto.setIdProducto(entity.getIdProducto());
        responseDto.setSku(entity.getSku());
        responseDto.setCodigoBarras(entity.getCodigoBarras());
        responseDto.setNombre(entity.getNombre());
        responseDto.setIdSubcategoria(entity.getSubcategoria().getIdSubcategoria());
        responseDto.setIdMarca(entity.getMarca().getIdMarca());
        responseDto.setPrecioCosto(entity.getPrecioCosto());
        return responseDto;

    }
    
}
