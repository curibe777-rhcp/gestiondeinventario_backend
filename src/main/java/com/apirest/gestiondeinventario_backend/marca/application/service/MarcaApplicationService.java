package com.apirest.gestiondeinventario_backend.marca.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.gestiondeinventario_backend.marca.application.dto.request.InsertarMarcaRequestDto;
import com.apirest.gestiondeinventario_backend.marca.application.dto.response.InsertarMarcaResponseDto;
import com.apirest.gestiondeinventario_backend.marca.application.mapper.InsertarMarcaMapper;
import com.apirest.gestiondeinventario_backend.marca.domain.entities.Marca;
import com.apirest.gestiondeinventario_backend.marca.domain.services.MarcaDomainService;

@Service
public class MarcaApplicationService {
    
    @Autowired
    MarcaDomainService marcaDomainService;

    @Autowired
    InsertarMarcaMapper insertarMarcaMapper;

    public InsertarMarcaResponseDto insertarMarca(InsertarMarcaRequestDto requestDto) {
        Marca marca = marcaDomainService.insertarMarca(insertarMarcaMapper.requestToEntity(requestDto));
        return insertarMarcaMapper.entityToResponse(marca);
    }
}
