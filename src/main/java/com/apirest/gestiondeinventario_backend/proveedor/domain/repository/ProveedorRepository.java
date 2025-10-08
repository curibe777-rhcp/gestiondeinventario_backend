package com.apirest.gestiondeinventario_backend.proveedor.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.gestiondeinventario_backend.proveedor.domain.entities.Proveedor;
import java.util.List;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
    List<Proveedor> findByEsDesactivado(Integer esDesactivado);
}
