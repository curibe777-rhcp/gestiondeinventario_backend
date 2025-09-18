package com.apirest.gestiondeinventario_backend.categoria.domain.services;

import java.time.LocalDateTime;
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

    public Categoria editarCategoria(Integer idCategoria, String nuevoNombre){
        Categoria categoria = categoriaRepository.findById(idCategoria).orElse(null);

        if (categoria != null) {
            categoria.setNombre(nuevoNombre);
            categoria.setFechaModificacion(LocalDateTime.now());
            return categoriaRepository.save(categoria);
        }

        return null;
    }

    public Categoria eliminarCategoria(Integer idCategoria){
        Categoria categoria = categoriaRepository.findById(idCategoria).orElse(null);

        if(categoria != null){
            categoria.setEsDesactivado(0);
            return categoriaRepository.save(categoria);
        }
        return null;
    }

}
