package com.apirest.gestiondeinventario_backend.marca.application.mapper;

import org.springframework.stereotype.Component;

import com.apirest.gestiondeinventario_backend.marca.application.dto.request.EliminarMarcaRequestDto;
import com.apirest.gestiondeinventario_backend.marca.application.dto.response.EliminarMarcaResponseDto;
import com.apirest.gestiondeinventario_backend.marca.domain.entities.Marca;
import com.apirest.gestiondeinventario_backend.common.application.IEntityDtoMapper;

@Component
public class EliminarMarcaMapper implements IEntityDtoMapper<Marca, EliminarMarcaRequestDto, EliminarMarcaResponseDto> {

    @Override
    public Marca requestToEntity(EliminarMarcaRequestDto requestDto) {
        Marca marca = new Marca();
        marca.setIdMarca(requestDto.getIdMarca());
        return marca;
    }

    @Override
    public EliminarMarcaResponseDto entityToResponse(Marca entity) {
        EliminarMarcaResponseDto responseDto = new EliminarMarcaResponseDto();
        responseDto.setIdMarca(entity.getIdMarca());
        responseDto.setNombre(entity.getNombre());
        return responseDto;
    }
}
