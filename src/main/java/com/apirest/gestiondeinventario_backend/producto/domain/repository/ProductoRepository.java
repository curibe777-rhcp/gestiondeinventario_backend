package com.apirest.gestiondeinventario_backend.producto.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.gestiondeinventario_backend.producto.domain.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    
}
