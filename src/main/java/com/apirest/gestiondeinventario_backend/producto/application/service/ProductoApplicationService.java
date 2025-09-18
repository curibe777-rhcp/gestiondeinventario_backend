package com.apirest.gestiondeinventario_backend.producto.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.gestiondeinventario_backend.marca.domain.repository.MarcaRepository;
import com.apirest.gestiondeinventario_backend.producto.application.dto.request.EditarProductoRequestDto;
import com.apirest.gestiondeinventario_backend.producto.application.dto.request.EliminarProductoRequestDto;
import com.apirest.gestiondeinventario_backend.producto.application.dto.request.InsertarProductoRequestDto;
import com.apirest.gestiondeinventario_backend.producto.application.dto.response.EditarProductoResponseDto;
import com.apirest.gestiondeinventario_backend.producto.application.dto.response.EliminarProductoResponseDto;
import com.apirest.gestiondeinventario_backend.producto.application.dto.response.InsertarProductoResponseDto;
import com.apirest.gestiondeinventario_backend.producto.application.dto.response.ListarProductosResponseDto;
import com.apirest.gestiondeinventario_backend.producto.application.mapper.EditarProductoMapper;
import com.apirest.gestiondeinventario_backend.producto.application.mapper.EliminarProductoMapper;
import com.apirest.gestiondeinventario_backend.producto.application.mapper.InsertarProductoMapper;
import com.apirest.gestiondeinventario_backend.producto.application.mapper.ListarProductosMapper;
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
    EditarProductoMapper editarProductoMapper;

    @Autowired
    EliminarProductoMapper eliminarProductoMapper;

    @Autowired
    ListarProductosMapper listarProductosMapper;

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

    public EditarProductoResponseDto editarProducto(EditarProductoRequestDto requestDto){
        Producto producto =editarProductoMapper.requestToEntity(requestDto);

        subcategoriaRepository.findById(requestDto.getIdSubcategoria()).ifPresent(producto::setSubcategoria);
        marcaRepository.findById(requestDto.getIdMarca()).ifPresent(producto::setMarca);

        Producto actualizado = productoDomainService.editarProducto(producto);
        return editarProductoMapper.entityToResponse(actualizado);
    }

    public EliminarProductoResponseDto eliminarProducto(EliminarProductoRequestDto requestDto) {
        Producto producto = eliminarProductoMapper.requestToEntity(requestDto);
        Producto eliminado = productoDomainService.eliminarProducto(producto.getIdProducto());

        return eliminarProductoMapper.entityToResponse(eliminado);
    }

    public List<ListarProductosResponseDto> listarProductos(){
        return productoDomainService.listarProductos(0).stream().map(listarProductosMapper::entityToResponse).toList();
    }

}
