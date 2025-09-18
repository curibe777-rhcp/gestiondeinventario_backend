package com.apirest.gestiondeinventario_backend.producto.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.gestiondeinventario_backend.producto.application.dto.request.EditarProductoRequestDto;
import com.apirest.gestiondeinventario_backend.producto.application.dto.request.EliminarProductoRequestDto;
import com.apirest.gestiondeinventario_backend.producto.application.dto.request.InsertarProductoRequestDto;
import com.apirest.gestiondeinventario_backend.producto.application.dto.response.EditarProductoResponseDto;
import com.apirest.gestiondeinventario_backend.producto.application.dto.response.EliminarProductoResponseDto;
import com.apirest.gestiondeinventario_backend.producto.application.dto.response.InsertarProductoResponseDto;
import com.apirest.gestiondeinventario_backend.producto.application.dto.response.ListarProductosResponseDto;
import com.apirest.gestiondeinventario_backend.producto.application.service.ProductoApplicationService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    
    @Autowired
    ProductoApplicationService productoApplicationService;

    @PostMapping("")
    public ResponseEntity<InsertarProductoResponseDto> insertarProducto(
        @RequestBody InsertarProductoRequestDto requestDto
    ){
        InsertarProductoResponseDto responseDto = productoApplicationService.insertarProducto(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("")
    public ResponseEntity<EditarProductoResponseDto> editarProducto(
        @RequestBody EditarProductoRequestDto requestDto
    ){
        EditarProductoResponseDto responseDto = productoApplicationService.editarProducto(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("")
    public ResponseEntity<EliminarProductoResponseDto> eliminarProducto(
            @RequestBody EliminarProductoRequestDto requestDto
    ){
        try {
            EliminarProductoResponseDto responseDto = productoApplicationService.eliminarProducto(requestDto);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<ListarProductosResponseDto>> listarProductos(){
        List<ListarProductosResponseDto> productos = productoApplicationService.listarProductos();
        return ResponseEntity.ok(productos);
    }

}
