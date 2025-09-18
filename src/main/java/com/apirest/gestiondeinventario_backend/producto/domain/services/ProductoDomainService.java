package com.apirest.gestiondeinventario_backend.producto.domain.services;

import java.time.LocalDateTime;
import java.util.List;

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

    public Producto editarProducto(Producto producto)
    {
        Producto existente = productoRepository.findById(producto.getIdProducto()).orElse(null);
        existente.setSku(producto.getSku());
        existente.setCodigoBarras(producto.getCodigoBarras());
        existente.setNombre(producto.getNombre());
        existente.setPrecioCosto(producto.getPrecioCosto());
        existente.setFechaModificacion(LocalDateTime.now());
        existente.setSubcategoria(producto.getSubcategoria());
        existente.setMarca(producto.getMarca());
        
        return productoRepository.save(existente);
    }

    public Producto eliminarProducto(Integer idProducto) {
        Producto producto = productoRepository.findById(idProducto).orElse(null);
        if (producto != null) {
            producto.setEsDesactivado(1);
            return productoRepository.save(producto);
        }

        return null;
    }

    public List<Producto> listarProductos(Integer esDesactivado){
        return productoRepository.findByEsDesactivado(0);
    }
    

}
