package com.apirest.gestiondeinventario_backend.marca.application.mapper;

import org.springframework.stereotype.Component;

import com.apirest.gestiondeinventario_backend.marca.application.dto.request.EditarMarcaRequestDto;
import com.apirest.gestiondeinventario_backend.marca.application.dto.response.EditarMarcaResponseDto;
import com.apirest.gestiondeinventario_backend.marca.domain.entities.Marca;
import com.apirest.gestiondeinventario_backend.common.application.IEntityDtoMapper;

@Component
public class EditarMarcaMapper implements IEntityDtoMapper<Marca, EditarMarcaRequestDto, EditarMarcaResponseDto> {

    @Override
    public Marca requestToEntity(EditarMarcaRequestDto requestDto) {
        Marca marca = new Marca();
        marca.setIdMarca(requestDto.getIdMarca());
        marca.setNombre(requestDto.getNombre());
        return marca;
    }

    @Override
    public EditarMarcaResponseDto entityToResponse(Marca entity) {
        EditarMarcaResponseDto responseDto = new EditarMarcaResponseDto();
        responseDto.setIdMarca(entity.getIdMarca());
        responseDto.setNombre(entity.getNombre());
        return responseDto;
    }
}
