package com.apirest.gestiondeinventario_backend.categoria.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.gestiondeinventario_backend.categoria.application.dto.request.InsertarCategoriaRequestDto;
import com.apirest.gestiondeinventario_backend.categoria.application.dto.response.InsertarCategoriaResponseDto;
import com.apirest.gestiondeinventario_backend.categoria.application.mapper.InsertarCategoriaMapper;
import com.apirest.gestiondeinventario_backend.categoria.domain.entities.Categoria;
import com.apirest.gestiondeinventario_backend.categoria.domain.services.CategoriaDomainService;

@Service
public class CategoriaApplicationService {
    
    @Autowired
    CategoriaDomainService categoriaDomainService;

    @Autowired
    InsertarCategoriaMapper insertarCategoriaMapper;

    public InsertarCategoriaResponseDto insertarCategoria(InsertarCategoriaRequestDto requestDto){
        Categoria categoria =  categoriaDomainService.insertarCategoria(insertarCategoriaMapper.requestToEntity(requestDto));
        return insertarCategoriaMapper.entityToResponse(categoria);
    }
}
