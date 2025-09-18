package com.apirest.gestiondeinventario_backend.categoria.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.gestiondeinventario_backend.categoria.application.dto.request.EditarCategoriaRequestDto;
import com.apirest.gestiondeinventario_backend.categoria.application.dto.request.InsertarCategoriaRequestDto;
import com.apirest.gestiondeinventario_backend.categoria.application.dto.response.EditarCategoriaResponseDto;
import com.apirest.gestiondeinventario_backend.categoria.application.dto.response.InsertarCategoriaResponseDto;
import com.apirest.gestiondeinventario_backend.categoria.application.service.CategoriaApplicationService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaApplicationService categoriaApplicationService;
    
    @PostMapping("")
    public ResponseEntity<InsertarCategoriaResponseDto> insertarCategoria(
        @RequestBody InsertarCategoriaRequestDto requestDto
    ){
        try {
            InsertarCategoriaResponseDto responseDto = categoriaApplicationService.insertarCategoria(requestDto);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }



    @PutMapping("")
    public ResponseEntity<EditarCategoriaResponseDto> editarCategoria(
        @RequestBody EditarCategoriaRequestDto requestDto
    ){
        EditarCategoriaResponseDto responseDto = categoriaApplicationService.editarCategoria(requestDto);

        if (responseDto != null) {
            return ResponseEntity.ok(responseDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
