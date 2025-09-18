package com.apirest.gestiondeinventario_backend.categoria.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.gestiondeinventario_backend.categoria.application.dto.request.EditarCategoriaRequestDto;
import com.apirest.gestiondeinventario_backend.categoria.application.dto.request.EliminarCategoriaRequestDto;
import com.apirest.gestiondeinventario_backend.categoria.application.dto.request.InsertarCategoriaRequestDto;
import com.apirest.gestiondeinventario_backend.categoria.application.dto.response.EditarCategoriaResponseDto;
import com.apirest.gestiondeinventario_backend.categoria.application.dto.response.EliminarCategoriaResponseDto;
import com.apirest.gestiondeinventario_backend.categoria.application.dto.response.InsertarCategoriaResponseDto;
import com.apirest.gestiondeinventario_backend.categoria.application.dto.response.ListarCategoriaResponseDto;
import com.apirest.gestiondeinventario_backend.categoria.application.mapper.EditarCategoriaMapper;
import com.apirest.gestiondeinventario_backend.categoria.application.mapper.EliminarCategoriaMapper;
import com.apirest.gestiondeinventario_backend.categoria.application.mapper.InsertarCategoriaMapper;
import com.apirest.gestiondeinventario_backend.categoria.application.mapper.ListarCategoriaMapper;
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

    @Autowired
    EliminarCategoriaMapper eliminarCategoriaMapper;

    @Autowired
    ListarCategoriaMapper listarCategoriaMapper;

    public InsertarCategoriaResponseDto insertarCategoria(InsertarCategoriaRequestDto requestDto){
        Categoria categoria =  categoriaDomainService.insertarCategoria(insertarCategoriaMapper.requestToEntity(requestDto));
        return insertarCategoriaMapper.entityToResponse(categoria);
    }

    public EditarCategoriaResponseDto editarCategoria(EditarCategoriaRequestDto requestDto){
        Categoria categoria = categoriaDomainService.editarCategoria(requestDto.getIdCategoria(), requestDto.getNombre());
        return editarCategoriaMapper.entityToResponse(categoria);
    }

    public EliminarCategoriaResponseDto eliminarCategoria(EliminarCategoriaRequestDto requestDto){
        Categoria categoria = eliminarCategoriaMapper.requestToEntity(requestDto);
        Categoria eliminada = categoriaDomainService.eliminarCategoria(categoria.getIdCategoria());

        return eliminarCategoriaMapper.entityToResponse(eliminada);
    }

    public List<ListarCategoriaResponseDto> listarCategorias(){
        return categoriaDomainService.listarCategorias(1).stream().map(listarCategoriaMapper::entityToResponse).toList();
    }
}
