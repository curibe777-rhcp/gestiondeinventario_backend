package com.apirest.gestiondeinventario_backend.producto.application.mapper;

import org.springframework.stereotype.Component;

import com.apirest.gestiondeinventario_backend.common.application.IEntityDtoMapper;
import com.apirest.gestiondeinventario_backend.producto.application.dto.request.ListarProductosRequestDto;
import com.apirest.gestiondeinventario_backend.producto.application.dto.response.ListarProductosResponseDto;
import com.apirest.gestiondeinventario_backend.producto.domain.entities.Producto;

@Component
public class ListarProductosMapper implements IEntityDtoMapper<Producto,ListarProductosRequestDto, ListarProductosResponseDto>{

    @Override
    public Producto requestToEntity(ListarProductosRequestDto requestDto) {
        return null;
    }

    @Override
    public ListarProductosResponseDto entityToResponse(Producto entity) {
        ListarProductosResponseDto responseDto = new ListarProductosResponseDto();
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
