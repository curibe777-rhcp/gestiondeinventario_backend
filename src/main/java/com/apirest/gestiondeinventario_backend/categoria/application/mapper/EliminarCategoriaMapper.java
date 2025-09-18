package com.apirest.gestiondeinventario_backend.categoria.application.mapper;

import org.springframework.stereotype.Component;

import com.apirest.gestiondeinventario_backend.categoria.application.dto.request.EliminarCategoriaRequestDto;
import com.apirest.gestiondeinventario_backend.categoria.application.dto.response.EliminarCategoriaResponseDto;
import com.apirest.gestiondeinventario_backend.categoria.domain.entities.Categoria;
import com.apirest.gestiondeinventario_backend.common.application.IEntityDtoMapper;

@Component
public class EliminarCategoriaMapper implements IEntityDtoMapper<Categoria, EliminarCategoriaRequestDto, EliminarCategoriaResponseDto> {

    @Override
    public Categoria requestToEntity(EliminarCategoriaRequestDto requestDto) {
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(requestDto.getIdCategoria());
        return categoria;
    }

    @Override
    public EliminarCategoriaResponseDto entityToResponse(Categoria entity) {
        EliminarCategoriaResponseDto responseDto = new EliminarCategoriaResponseDto();
        responseDto.setIdCategoria(entity.getIdCategoria());
        responseDto.setCodigo(entity.getCodigo());
        responseDto.setNombre(entity.getNombre());
        return responseDto;
    }
    
}
