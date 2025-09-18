package com.apirest.gestiondeinventario_backend.marca.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.gestiondeinventario_backend.marca.domain.entities.Marca;
import java.util.List;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer> {
    List<Marca> findByEsDesactivado(Integer esDesactivado);
}
