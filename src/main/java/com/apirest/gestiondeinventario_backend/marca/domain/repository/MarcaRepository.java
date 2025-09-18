package com.apirest.gestiondeinventario_backend.marca.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.gestiondeinventario_backend.marca.domain.entities.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer> {
    
}
