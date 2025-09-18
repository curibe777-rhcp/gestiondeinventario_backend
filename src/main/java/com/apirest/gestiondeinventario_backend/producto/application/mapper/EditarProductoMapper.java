package com.apirest.gestiondeinventario_backend.producto.application.mapper;

import org.springframework.stereotype.Component;

import com.apirest.gestiondeinventario_backend.common.application.IEntityDtoMapper;
import com.apirest.gestiondeinventario_backend.marca.domain.entities.Marca;
import com.apirest.gestiondeinventario_backend.producto.application.dto.request.EditarProductoRequestDto;
import com.apirest.gestiondeinventario_backend.producto.application.dto.response.EditarProductoResponseDto;
import com.apirest.gestiondeinventario_backend.producto.domain.entities.Producto;
import com.apirest.gestiondeinventario_backend.subcategoria.domain.entities.Subcategoria;

@Component
public class EditarProductoMapper implements IEntityDtoMapper<Producto, EditarProductoRequestDto, EditarProductoResponseDto> {

    @Override
    public Producto requestToEntity(EditarProductoRequestDto requestDto) {
        Producto producto = new Producto();
        producto.setIdProducto(requestDto.getIdProducto());
        producto.setSku(requestDto.getSku());
        producto.setCodigoBarras(requestDto.getCodigoBarras());
        producto.setNombre(requestDto.getNombre());
        producto.setPrecioCosto(requestDto.getPrecioCosto());
        producto.setSubcategoria(new Subcategoria());
        producto.getSubcategoria().setIdSubcategoria(requestDto.getIdSubcategoria());
        producto.setMarca(new Marca());
        producto.getMarca().setIdMarca(requestDto.getIdMarca());

        return producto;
    }

    @Override
    public EditarProductoResponseDto entityToResponse(Producto entity) {
        EditarProductoResponseDto responseDto = new EditarProductoResponseDto();
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
