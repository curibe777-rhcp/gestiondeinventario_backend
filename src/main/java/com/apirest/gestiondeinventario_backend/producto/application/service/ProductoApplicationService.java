package com.apirest.gestiondeinventario_backend.producto.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.gestiondeinventario_backend.marca.domain.repository.MarcaRepository;
import com.apirest.gestiondeinventario_backend.producto.application.dto.request.InsertarProductoRequestDto;
import com.apirest.gestiondeinventario_backend.producto.application.dto.response.InsertarProductoResponseDto;
import com.apirest.gestiondeinventario_backend.producto.application.mapper.InsertarProductoMapper;
import com.apirest.gestiondeinventario_backend.producto.domain.entities.Producto;
import com.apirest.gestiondeinventario_backend.producto.domain.services.ProductoDomainService;
import com.apirest.gestiondeinventario_backend.subcategoria.domain.repository.SubcategoriaRepository;

@Service
public class ProductoApplicationService {
    
    @Autowired
    ProductoDomainService productoDomainService;

    @Autowired
    InsertarProductoMapper insertarProductoMapper;

    @Autowired
    SubcategoriaRepository subcategoriaRepository;

    @Autowired
    MarcaRepository marcaRepository;


    public InsertarProductoResponseDto insertarProducto(InsertarProductoRequestDto requestDto){
        Producto producto = insertarProductoMapper.requestToEntity(requestDto);
        subcategoriaRepository.findById(requestDto.getIdSubcategoria()).ifPresent(producto::setSubcategoria);;

        marcaRepository.findById(requestDto.getIdMarca()).ifPresent(producto::setMarca);;

        Producto guardado = productoDomainService.insertarProducto(producto);

        return insertarProductoMapper.entityToResponse(guardado);
    }
}
