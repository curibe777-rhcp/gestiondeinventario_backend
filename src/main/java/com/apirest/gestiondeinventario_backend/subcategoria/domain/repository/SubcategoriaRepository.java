package com.apirest.gestiondeinventario_backend.subcategoria.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.gestiondeinventario_backend.subcategoria.domain.entities.Subcategoria;

@Repository
public interface SubcategoriaRepository extends JpaRepository<Subcategoria, Integer> {
    
}
