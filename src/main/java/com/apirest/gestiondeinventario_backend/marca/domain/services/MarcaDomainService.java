package com.apirest.gestiondeinventario_backend.marca.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.gestiondeinventario_backend.marca.domain.entities.Marca;
import com.apirest.gestiondeinventario_backend.marca.domain.repository.MarcaRepository;

@Service
public class MarcaDomainService {
    
    @Autowired
    MarcaRepository marcaRepository;

    public Marca insertarMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    public List<Marca> listarMarcas() {
        return marcaRepository.findAll();
    }
}
