package com.apirest.gestiondeinventario_backend.producto.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.gestiondeinventario_backend.producto.application.dto.request.InsertarProductoRequestDto;
import com.apirest.gestiondeinventario_backend.producto.application.dto.response.InsertarProductoResponseDto;
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
}
