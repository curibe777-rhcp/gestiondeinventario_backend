package com.apirest.gestiondeinventario_backend.proveedor.domain.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.gestiondeinventario_backend.proveedor.domain.entities.Proveedor;
import com.apirest.gestiondeinventario_backend.proveedor.domain.repository.ProveedorRepository;

@Service
public class ProveedorDomainService {
    
    @Autowired
    private ProveedorRepository proveedorRepository;

    public Proveedor insertarProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public List<Proveedor> listarProveedores(Integer esDesactivado) {
        return proveedorRepository.findByEsDesactivado(esDesactivado);
    }

    public Proveedor editarProveedor(Proveedor proveedor) {
        Proveedor existente = proveedorRepository.findById(proveedor.getIdProveedor()).orElse(null);
        if (existente != null) {
            existente.setTipoDocumento(proveedor.getTipoDocumento());
            existente.setNumeroDocumento(proveedor.getNumeroDocumento());
            existente.setRazonSocial(proveedor.getRazonSocial());
            existente.setNombreComercial(proveedor.getNombreComercial());
            existente.setContacto(proveedor.getContacto());
            existente.setTelefono(proveedor.getTelefono());
            existente.setDireccion(proveedor.getDireccion());
            existente.setDistrito(proveedor.getDistrito());
            existente.setFechaModificacion(LocalDateTime.now());
            return proveedorRepository.save(existente);
        }

        return null;
    }

    public Proveedor eliminarProveedor(Integer idProveedor) {
        Proveedor proveedor = proveedorRepository.findById(idProveedor).orElse(null);

        if (proveedor != null) {
            proveedor.setEsDesactivado(1);
            return proveedorRepository.save(proveedor);
        }
        return null;
    }
}
