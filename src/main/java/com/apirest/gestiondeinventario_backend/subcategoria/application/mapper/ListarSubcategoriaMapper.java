package com.apirest.gestiondeinventario_backend.subcategoria.application.mapper;

import org.springframework.stereotype.Component;
import com.apirest.gestiondeinventario_backend.common.application.IEntityDtoMapper;
import com.apirest.gestiondeinventario_backend.subcategoria.domain.entities.Subcategoria;
import com.apirest.gestiondeinventario_backend.subcategoria.application.dto.request.ListarSubcategoriaRequestDto;
import com.apirest.gestiondeinventario_backend.subcategoria.application.dto.response.ListarSubcategoriaResponseDto;

@Component
public class ListarSubcategoriaMapper implements IEntityDtoMapper<Subcategoria, ListarSubcategoriaRequestDto, ListarSubcategoriaResponseDto> {

    @Override
    public Subcategoria requestToEntity(ListarSubcategoriaRequestDto requestDto) {
        return null;
    }

    @Override
    public ListarSubcategoriaResponseDto entityToResponse(Subcategoria entity) {
        ListarSubcategoriaResponseDto responseDto = new ListarSubcategoriaResponseDto();
        responseDto.setIdSubcategoria(entity.getIdSubcategoria());
        responseDto.setCodigo(entity.getCodigo());
        responseDto.setNombre(entity.getNombre());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
