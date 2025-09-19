package com.apirest.gestiondeinventario_backend.subcategoria.domain.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.gestiondeinventario_backend.subcategoria.domain.entities.Subcategoria;
import com.apirest.gestiondeinventario_backend.subcategoria.domain.repository.SubcategoriaRepository;
import com.apirest.gestiondeinventario_backend.categoria.domain.entities.Categoria;
import com.apirest.gestiondeinventario_backend.categoria.domain.repository.CategoriaRepository;

@Service
public class SubcategoriaDomainService {
    
    @Autowired
    private SubcategoriaRepository subcategoriaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Subcategoria insertarSubcategoria(Subcategoria subcategoria){
        if (subcategoria.getCategoria() != null && subcategoria.getCategoria().getIdCategoria() != null) {
            Optional<Categoria> categoriaOptional = categoriaRepository.findById(subcategoria.getCategoria().getIdCategoria());
            if (categoriaOptional.isPresent()) {
                subcategoria.setCategoria(categoriaOptional.get());
                return subcategoriaRepository.save(subcategoria);
            } else {
                throw new RuntimeException("Categoría no encontrada con ID: " + subcategoria.getCategoria().getIdCategoria());
            }
        } else {
            throw new RuntimeException("ID de categoría no proporcionado.");
        }
    }

    public List<Subcategoria> listarSubcategorias(){
        return subcategoriaRepository.findByEsDesactivado('0');
    }

    public Subcategoria editarSubcategoria(Integer idSubcategoria, Integer nuevoCodigo, String nuevoNombre, Integer idCategoria){
        Optional<Subcategoria> subcategoriaOptional = subcategoriaRepository.findById(idSubcategoria);

        if (subcategoriaOptional.isPresent()) {
            Subcategoria subcategoria = subcategoriaOptional.get();

            if (nuevoCodigo != null) {
                subcategoria.setCodigo(nuevoCodigo);
            }
            if (nuevoNombre != null) {
                subcategoria.setNombre(nuevoNombre);
            }
            if (idCategoria != null) {
                Optional<Categoria> categoriaOptional = categoriaRepository.findById(idCategoria);
                if (categoriaOptional.isPresent()) {
                    subcategoria.setCategoria(categoriaOptional.get());
                } else {
                    throw new RuntimeException("Categoría no encontrada con ID: " + idCategoria);
                }
            }

            subcategoria.setFechaModificacion(LocalDateTime.now());
            return subcategoriaRepository.save(subcategoria);
        }

        return null;
    }

    public Subcategoria eliminarSubcategoria(Integer idSubcategoria){
        Optional<Subcategoria> subcategoriaOptional = subcategoriaRepository.findById(idSubcategoria);
        
        if(subcategoriaOptional.isPresent()){
            Subcategoria subcategoria = subcategoriaOptional.get();
            subcategoria.setEsDesactivado('1');
            subcategoria.setFechaModificacion(LocalDateTime.now());
            return subcategoriaRepository.save(subcategoria);
        }
        return null;
    }
}
