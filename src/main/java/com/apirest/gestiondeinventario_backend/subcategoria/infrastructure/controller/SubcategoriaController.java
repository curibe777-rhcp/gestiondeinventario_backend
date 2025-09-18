package com.apirest.gestiondeinventario_backend.subcategoria.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.gestiondeinventario_backend.subcategoria.application.dto.request.InsertarSubcategoriaRequestDto;
import com.apirest.gestiondeinventario_backend.subcategoria.application.dto.response.InsertarSubcategoriaResponseDto;
import com.apirest.gestiondeinventario_backend.subcategoria.application.service.SubcategoriaApplicationService;

@RestController
@RequestMapping("/subcategorias")
public class SubcategoriaController {

    @Autowired
    private SubcategoriaApplicationService subcategoriaApplicationService;
    
    @PostMapping("")
    public ResponseEntity<InsertarSubcategoriaResponseDto> insertarSubcategoria(
        @RequestBody InsertarSubcategoriaRequestDto requestDto
    ){
        try {
            InsertarSubcategoriaResponseDto responseDto = subcategoriaApplicationService.insertarSubcategoria(requestDto);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
