package com.apirest.gestiondeinventario_backend.marca.application.mapper;

import org.springframework.stereotype.Component;

import com.apirest.gestiondeinventario_backend.marca.application.dto.request.InsertarMarcaRequestDto;
import com.apirest.gestiondeinventario_backend.marca.application.dto.response.InsertarMarcaResponseDto;
import com.apirest.gestiondeinventario_backend.marca.domain.entities.Marca;
import com.apirest.gestiondeinventario_backend.common.application.IEntityDtoMapper;

@Component
public class InsertarMarcaMapper implements IEntityDtoMapper<Marca, InsertarMarcaRequestDto, InsertarMarcaResponseDto> {

    @Override
    public Marca requestToEntity(InsertarMarcaRequestDto requestDto) {
        Marca marca = new Marca();
        marca.setNombre(requestDto.getNombre());
        return marca;
    }

    @Override
    public InsertarMarcaResponseDto entityToResponse(Marca entity) {
        InsertarMarcaResponseDto responseDto = new InsertarMarcaResponseDto();
        responseDto.setNombre(entity.getNombre());
        return responseDto;
    }
}
