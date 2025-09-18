package com.apirest.gestiondeinventario_backend.categoria.application.mapper;

import com.apirest.gestiondeinventario_backend.categoria.application.dto.request.InsertarCategoriaRequestDto;
import com.apirest.gestiondeinventario_backend.categoria.application.dto.response.InsertarCategoriaResponseDto;
import com.apirest.gestiondeinventario_backend.categoria.domain.entities.Categoria;
import com.apirest.gestiondeinventario_backend.common.application.IEntityDtoMapper;

public class InsertarCategoriaMapper implements IEntityDtoMapper<Categoria, InsertarCategoriaRequestDto, InsertarCategoriaResponseDto> {

    @Override
    public Categoria requestToEntity(InsertarCategoriaRequestDto requestDto) {
        Categoria categoria = new Categoria();
        categoria.setCodigo(requestDto.getCodigo());
        categoria.setNombre(requestDto.getNombre());
        return categoria;
    }

    @Override
    public InsertarCategoriaResponseDto entityToResponse(Categoria entity) {
        InsertarCategoriaResponseDto responseDto = new InsertarCategoriaResponseDto();
        responseDto.setCodigo(entity.getCodigo());
        responseDto.setNombre(entity.getNombre());
        responseDto.setIdCategoria(entity.getIdCategoria());
        return responseDto;
    }
    
    
}
