package com.apirest.gestiondeinventario_backend.categoria.domain.services;

import org.springframework.stereotype.Service;

import com.apirest.gestiondeinventario_backend.categoria.domain.entities.Categoria;

@Service
public class CategoriaDomainService {
    
    public Categoria insertarCategoria(Categoria categoria){
        categoria.setIdCategoria(1);
        return categoria;
    }
}
