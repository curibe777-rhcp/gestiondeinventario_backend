package com.apirest.gestiondeinventario_backend.subcategoria.application.mapper;

import org.springframework.stereotype.Component;

import com.apirest.gestiondeinventario_backend.subcategoria.application.dto.request.InsertarSubcategoriaRequestDto;
import com.apirest.gestiondeinventario_backend.subcategoria.application.dto.response.InsertarSubcategoriaResponseDto;
import com.apirest.gestiondeinventario_backend.subcategoria.domain.entities.Subcategoria;
import com.apirest.gestiondeinventario_backend.common.application.IEntityDtoMapper;

@Component
public class InsertarSubcategoriaMapper implements IEntityDtoMapper<Subcategoria, InsertarSubcategoriaRequestDto, InsertarSubcategoriaResponseDto> {

    @Override
    public Subcategoria requestToEntity(InsertarSubcategoriaRequestDto requestDto) {
        Subcategoria categoria = new Subcategoria();
        categoria.setCodigo(requestDto.getCodigo());
        categoria.setNombre(requestDto.getNombre());
        return categoria;
    }

    @Override
    public InsertarSubcategoriaResponseDto entityToResponse(Subcategoria entity) {
        InsertarSubcategoriaResponseDto responseDto = new InsertarSubcategoriaResponseDto();
        responseDto.setCodigo(entity.getCodigo());
        responseDto.setNombre(entity.getNombre());
        responseDto.setIdSubcategoria(entity.getIdSubcategoria());
        return responseDto;
    }
    
    
}
