package com.apirest.gestiondeinventario_backend.categoria.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.gestiondeinventario_backend.categoria.domain.entities.Categoria;
import com.apirest.gestiondeinventario_backend.categoria.domain.repository.CategoriaRepository;

@Service
public class CategoriaDomainService {
    
    @Autowired
    CategoriaRepository categoriaRepository;

    public Categoria insertarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listarCategorias(){
        return categoriaRepository.findAll();
    }
}
