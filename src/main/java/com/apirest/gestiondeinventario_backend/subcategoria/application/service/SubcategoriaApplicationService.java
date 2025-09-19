package com.apirest.gestiondeinventario_backend.subcategoria.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.gestiondeinventario_backend.subcategoria.application.dto.request.InsertarSubcategoriaRequestDto;
import com.apirest.gestiondeinventario_backend.subcategoria.application.dto.request.EditarSubcategoriaRequestDto;
import com.apirest.gestiondeinventario_backend.subcategoria.application.dto.request.EliminarSubcategoriaRequestDto;
import com.apirest.gestiondeinventario_backend.subcategoria.application.dto.response.InsertarSubcategoriaResponseDto;
import com.apirest.gestiondeinventario_backend.subcategoria.application.dto.response.ListarSubcategoriaResponseDto;
import com.apirest.gestiondeinventario_backend.subcategoria.application.dto.response.EditarSubcategoriaResponseDto;
import com.apirest.gestiondeinventario_backend.subcategoria.application.dto.response.EliminarSubcategoriaResponseDto;
import com.apirest.gestiondeinventario_backend.subcategoria.domain.entities.Subcategoria;
import com.apirest.gestiondeinventario_backend.subcategoria.domain.services.SubcategoriaDomainService;
import com.apirest.gestiondeinventario_backend.subcategoria.application.mapper.InsertarSubcategoriaMapper;
import com.apirest.gestiondeinventario_backend.subcategoria.application.mapper.ListarSubcategoriaMapper;
import com.apirest.gestiondeinventario_backend.subcategoria.application.mapper.EditarSubcategoriaMapper;
import com.apirest.gestiondeinventario_backend.subcategoria.application.mapper.EliminarSubcategoriaMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubcategoriaApplicationService {

    @Autowired
    private SubcategoriaDomainService subcategoriaDomainService;

    @Autowired
    private InsertarSubcategoriaMapper insertarSubcategoriaMapper;

    @Autowired
    private ListarSubcategoriaMapper listarSubcategoriaMapper;

    @Autowired
    private EditarSubcategoriaMapper editarSubcategoriaMapper;

    @Autowired
    private EliminarSubcategoriaMapper eliminarSubcategoriaMapper;

    public InsertarSubcategoriaResponseDto insertarSubcategoria(InsertarSubcategoriaRequestDto requestDto){
        Subcategoria subcategoria = insertarSubcategoriaMapper.requestToEntity(requestDto);
        subcategoria = subcategoriaDomainService.insertarSubcategoria(subcategoria);
        return insertarSubcategoriaMapper.entityToResponse(subcategoria);
    }
    
    public List<ListarSubcategoriaResponseDto> listarSubcategorias(){
        List<Subcategoria> subcategorias = subcategoriaDomainService.listarSubcategorias();
        return subcategorias.stream()
            .map(listarSubcategoriaMapper::entityToResponse)
            .collect(Collectors.toList());
    }

    public EditarSubcategoriaResponseDto editarSubcategoria(EditarSubcategoriaRequestDto requestDto){
        Subcategoria subcategoria = subcategoriaDomainService.editarSubcategoria(requestDto.getIdSubcategoria(), requestDto.getCodigo(), requestDto.getNombre(), requestDto.getIdCategoria());
        return editarSubcategoriaMapper.entityToResponse(subcategoria);
    }
    
    public EliminarSubcategoriaResponseDto eliminarSubcategoria(EliminarSubcategoriaRequestDto requestDto){
        Subcategoria subcategoria = subcategoriaDomainService.eliminarSubcategoria(requestDto.getIdSubcategoria());
        return eliminarSubcategoriaMapper.entityToResponse(subcategoria);
    }
}
