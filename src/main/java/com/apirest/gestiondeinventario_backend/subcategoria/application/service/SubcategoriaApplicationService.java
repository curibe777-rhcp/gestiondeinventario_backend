package com.apirest.gestiondeinventario_backend.subcategoria.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.gestiondeinventario_backend.subcategoria.application.dto.request.InsertarSubcategoriaRequestDto;
import com.apirest.gestiondeinventario_backend.subcategoria.application.dto.response.InsertarSubcategoriaResponseDto;
import com.apirest.gestiondeinventario_backend.subcategoria.application.mapper.InsertarSubcategoriaMapper;
import com.apirest.gestiondeinventario_backend.subcategoria.domain.entities.Subcategoria;
import com.apirest.gestiondeinventario_backend.subcategoria.domain.repository.SubcategoriaRepository;
import com.apirest.gestiondeinventario_backend.categoria.domain.entities.Categoria;
import com.apirest.gestiondeinventario_backend.categoria.domain.repository.CategoriaRepository;

import java.util.Optional;

@Service
public class SubcategoriaApplicationService {
    @Autowired
    private SubcategoriaRepository subcategoriaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private InsertarSubcategoriaMapper insertarSubcategoriaMapper;

    public InsertarSubcategoriaResponseDto insertarSubcategoria(InsertarSubcategoriaRequestDto requestDto){
        
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(requestDto.getIdCategoria());

        if (categoriaOptional.isEmpty()) {
            throw new RuntimeException("Categoría no encontrada con el ID: " + requestDto.getIdCategoria());
        }

        Subcategoria subcategoria = insertarSubcategoriaMapper.requestToEntity(requestDto);

        subcategoria.setCategoria(categoriaOptional.get());
        
        Subcategoria savedSubcategoria = subcategoriaRepository.save(subcategoria);

        return insertarSubcategoriaMapper.entityToResponse(savedSubcategoria);
    }
}
