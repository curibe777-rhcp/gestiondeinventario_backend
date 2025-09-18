package com.apirest.gestiondeinventario_backend.subcategoria.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.gestiondeinventario_backend.subcategoria.domain.entities.Subcategoria;
import com.apirest.gestiondeinventario_backend.subcategoria.domain.repository.SubcategoriaRepository;

@Service
public class SubcategoriaDomainService {
    
    @Autowired
    SubcategoriaRepository subcategoriaRepository;

    public Subcategoria insertarSubcategoria(Subcategoria subcategoria){
        return subcategoriaRepository.save(subcategoria);
    }

    public List<Subcategoria> listarSubcategorias(){
        return subcategoriaRepository.findAll();
    }
}
