package com.apirest.gestiondeinventario_backend.categoria.application.mapper;

import org.springframework.stereotype.Component;

import com.apirest.gestiondeinventario_backend.categoria.application.dto.request.ListarCategoriaRequestDto;
import com.apirest.gestiondeinventario_backend.categoria.application.dto.response.ListarCategoriaResponseDto;
import com.apirest.gestiondeinventario_backend.categoria.domain.entities.Categoria;
import com.apirest.gestiondeinventario_backend.common.application.IEntityDtoMapper;

@Component
public class ListarCategoriaMapper implements IEntityDtoMapper<Categoria, ListarCategoriaRequestDto, ListarCategoriaResponseDto> {

    @Override
    public Categoria requestToEntity(ListarCategoriaRequestDto requestDto) {
        return null;
    }

    @Override
    public ListarCategoriaResponseDto entityToResponse(Categoria entity) {
        ListarCategoriaResponseDto responseDto = new ListarCategoriaResponseDto();
        responseDto.setIdCategoria(entity.getIdCategoria());
        responseDto.setCodigo(entity.getCodigo());
        responseDto.setNombre(entity.getNombre());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
    
}
