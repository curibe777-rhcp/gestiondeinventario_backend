package com.apirest.gestiondeinventario_backend.producto.application.mapper;

import org.springframework.stereotype.Component;

import com.apirest.gestiondeinventario_backend.common.application.IEntityDtoMapper;
import com.apirest.gestiondeinventario_backend.producto.application.dto.request.EliminarProductoRequestDto;
import com.apirest.gestiondeinventario_backend.producto.application.dto.response.EliminarProductoResponseDto;
import com.apirest.gestiondeinventario_backend.producto.domain.entities.Producto;

@Component
public class EliminarProductoMapper implements IEntityDtoMapper<Producto, EliminarProductoRequestDto, EliminarProductoResponseDto> {

    @Override
    public Producto requestToEntity(EliminarProductoRequestDto requestDto) {
        Producto producto = new Producto();
        producto.setIdProducto(requestDto.getIdProducto());
        producto.setEsDesactivado(1);
        return producto;
    }

    @Override
    public EliminarProductoResponseDto entityToResponse(Producto entity) {
        EliminarProductoResponseDto responseDto = new EliminarProductoResponseDto();
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
