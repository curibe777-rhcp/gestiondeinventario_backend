package com.apirest.gestiondeinventario_backend.subcategoria.application.mapper;

import org.springframework.stereotype.Component;

import com.apirest.gestiondeinventario_backend.subcategoria.application.dto.request.EditarSubcategoriaRequestDto;
import com.apirest.gestiondeinventario_backend.subcategoria.application.dto.response.EditarSubcategoriaResponseDto;
import com.apirest.gestiondeinventario_backend.subcategoria.domain.entities.Subcategoria;
import com.apirest.gestiondeinventario_backend.common.application.IEntityDtoMapper;
import com.apirest.gestiondeinventario_backend.categoria.domain.entities.Categoria;

@Component
public class EditarSubcategoriaMapper implements IEntityDtoMapper<Subcategoria, EditarSubcategoriaRequestDto, EditarSubcategoriaResponseDto>{

    @Override
    public Subcategoria requestToEntity(EditarSubcategoriaRequestDto requestDto) {
        Subcategoria subcategoria = new Subcategoria();
        subcategoria.setIdSubcategoria(requestDto.getIdSubcategoria());
        subcategoria.setCodigo(requestDto.getCodigo());
        subcategoria.setNombre(requestDto.getNombre());
        if (requestDto.getIdCategoria() != null) {
            Categoria categoria = new Categoria();
            categoria.setIdCategoria(requestDto.getIdCategoria());
            subcategoria.setCategoria(categoria);
        }
        return subcategoria;
    }

    @Override
    public EditarSubcategoriaResponseDto entityToResponse(Subcategoria entity) {
        EditarSubcategoriaResponseDto responseDto = new EditarSubcategoriaResponseDto();
        responseDto.setIdSubcategoria(entity.getIdSubcategoria());
        responseDto.setCodigo(entity.getCodigo());
        responseDto.setNombre(entity.getNombre());
        return responseDto;
    }
}
