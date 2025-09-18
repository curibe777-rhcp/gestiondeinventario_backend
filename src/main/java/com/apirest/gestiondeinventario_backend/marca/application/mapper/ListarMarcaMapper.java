package com.apirest.gestiondeinventario_backend.marca.application.mapper;

import org.springframework.stereotype.Component;

import com.apirest.gestiondeinventario_backend.marca.application.dto.request.ListarMarcaRequestDto;
import com.apirest.gestiondeinventario_backend.marca.application.dto.response.ListarMarcaResponseDto;
import com.apirest.gestiondeinventario_backend.marca.domain.entities.Marca;
import com.apirest.gestiondeinventario_backend.common.application.IEntityDtoMapper;

@Component
public class ListarMarcaMapper implements IEntityDtoMapper<Marca, ListarMarcaRequestDto, ListarMarcaResponseDto> {

    @Override
    public Marca requestToEntity(ListarMarcaRequestDto requestDto) {
        return null;
    }

    @Override
    public ListarMarcaResponseDto entityToResponse(Marca entity) {
        ListarMarcaResponseDto responseDto = new ListarMarcaResponseDto();
        responseDto.setIdMarca(entity.getIdMarca());
        responseDto.setNombre(entity.getNombre());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
