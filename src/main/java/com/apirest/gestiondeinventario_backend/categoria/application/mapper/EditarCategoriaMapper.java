package com.apirest.gestiondeinventario_backend.categoria.application.mapper;

import org.springframework.stereotype.Component;

import com.apirest.gestiondeinventario_backend.categoria.application.dto.request.EditarCategoriaRequestDto;
import com.apirest.gestiondeinventario_backend.categoria.application.dto.response.EditarCategoriaResponseDto;
import com.apirest.gestiondeinventario_backend.categoria.domain.entities.Categoria;
import com.apirest.gestiondeinventario_backend.common.application.IEntityDtoMapper;

@Component
public class EditarCategoriaMapper implements IEntityDtoMapper<Categoria, EditarCategoriaRequestDto, EditarCategoriaResponseDto>{

    @Override
    public Categoria requestToEntity(EditarCategoriaRequestDto requestDto) {
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(requestDto.getIdCategoria());
        categoria.setNombre(requestDto.getNombre());
        return categoria;
    }

    @Override
    public EditarCategoriaResponseDto entityToResponse(Categoria entity) {
        EditarCategoriaResponseDto responseDto = new EditarCategoriaResponseDto();
        responseDto.setIdCategoria(entity.getIdCategoria());
        responseDto.setCodigo(entity.getCodigo());
        responseDto.setNombre(entity.getNombre());
        return responseDto;
    }
    
    
}
