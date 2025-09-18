package com.apirest.gestiondeinventario_backend.marca.domain.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.gestiondeinventario_backend.marca.domain.entities.Marca;
import com.apirest.gestiondeinventario_backend.marca.domain.repository.MarcaRepository;

@Service
public class MarcaDomainService {
    
    @Autowired
    private MarcaRepository marcaRepository;

    public Marca insertarMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    public List<Marca> listarMarcas(Integer esDesactivado) {
        return marcaRepository.findByEsDesactivado(1);
    }

    public Marca editarMarca(Integer idMarca, String nuevoNombre) {
        Marca marca = marcaRepository.findById(idMarca).orElse(null);

        if (marca != null) {
            marca.setNombre(nuevoNombre);
            marca.setFechaModificacion(LocalDateTime.now());
            return marcaRepository.save(marca);
        }

        return null;
    }

    public Marca eliminarMarca(Integer idMarca) {
        Marca marca = marcaRepository.findById(idMarca).orElse(null);

        if (marca != null) {
            marca.setEsDesactivado(0);
            return marcaRepository.save(marca);
        }
        return null;
    }
}
