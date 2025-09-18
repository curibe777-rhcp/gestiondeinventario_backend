package com.apirest.gestiondeinventario_backend.producto.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.gestiondeinventario_backend.producto.domain.entities.Producto;
import com.apirest.gestiondeinventario_backend.producto.domain.repository.ProductoRepository;

@Service
public class ProductoDomainService {
    
    @Autowired
    ProductoRepository productoRepository;

    public Producto insertarProducto(Producto producto)
    {
        return productoRepository.save(producto);
    }
}
