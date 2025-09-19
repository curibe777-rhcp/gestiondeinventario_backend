package com.apirest.gestiondeinventario_backend.subcategoria.application.mapper;

import org.springframework.stereotype.Component;
import com.apirest.gestiondeinventario_backend.common.application.IEntityDtoMapper;
import com.apirest.gestiondeinventario_backend.subcategoria.domain.entities.Subcategoria;
import com.apirest.gestiondeinventario_backend.subcategoria.application.dto.request.EliminarSubcategoriaRequestDto;
import com.apirest.gestiondeinventario_backend.subcategoria.application.dto.response.EliminarSubcategoriaResponseDto;

@Component
public class EliminarSubcategoriaMapper implements IEntityDtoMapper<Subcategoria, EliminarSubcategoriaRequestDto, EliminarSubcategoriaResponseDto> {

    @Override
    public Subcategoria requestToEntity(EliminarSubcategoriaRequestDto requestDto) {
        Subcategoria subcategoria = new Subcategoria();
        subcategoria.setIdSubcategoria(requestDto.getIdSubcategoria());
        return subcategoria;
    }

    @Override
    public EliminarSubcategoriaResponseDto entityToResponse(Subcategoria entity) {
        EliminarSubcategoriaResponseDto responseDto = new EliminarSubcategoriaResponseDto();
        responseDto.setMensaje("Subcategoría eliminada con éxito.");
        return responseDto;
    }
}
