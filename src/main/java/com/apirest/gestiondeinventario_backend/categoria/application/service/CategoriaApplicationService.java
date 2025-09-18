package com.apirest.gestiondeinventario_backend.categoria.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.gestiondeinventario_backend.categoria.application.dto.request.EditarCategoriaRequestDto;
import com.apirest.gestiondeinventario_backend.categoria.application.dto.request.InsertarCategoriaRequestDto;
import com.apirest.gestiondeinventario_backend.categoria.application.dto.response.EditarCategoriaResponseDto;
import com.apirest.gestiondeinventario_backend.categoria.application.dto.response.InsertarCategoriaResponseDto;
import com.apirest.gestiondeinventario_backend.categoria.application.mapper.EditarCategoriaMapper;
import com.apirest.gestiondeinventario_backend.categoria.application.mapper.InsertarCategoriaMapper;
import com.apirest.gestiondeinventario_backend.categoria.domain.entities.Categoria;
import com.apirest.gestiondeinventario_backend.categoria.domain.services.CategoriaDomainService;

@Service
public class CategoriaApplicationService {
    
    @Autowired
    CategoriaDomainService categoriaDomainService;

    @Autowired
    InsertarCategoriaMapper insertarCategoriaMapper;

    @Autowired
    EditarCategoriaMapper editarCategoriaMapper;

    public InsertarCategoriaResponseDto insertarCategoria(InsertarCategoriaRequestDto requestDto){
        Categoria categoria =  categoriaDomainService.insertarCategoria(insertarCategoriaMapper.requestToEntity(requestDto));
        return insertarCategoriaMapper.entityToResponse(categoria);
    }

    public EditarCategoriaResponseDto editarCategoria(EditarCategoriaRequestDto requestDto){
        Categoria categoria = categoriaDomainService.editarCategoria(requestDto.getIdCategoria(), requestDto.getNombre());
        return editarCategoriaMapper.entityToResponse(categoria);
    }
}
