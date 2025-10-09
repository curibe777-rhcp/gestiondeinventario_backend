package com.apirest.gestiondeinventario_backend.subcategoria.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.gestiondeinventario_backend.subcategoria.application.dto.request.InsertarSubcategoriaRequestDto;
import com.apirest.gestiondeinventario_backend.common.application.dto.response.BaseResponseDto;
import com.apirest.gestiondeinventario_backend.subcategoria.application.dto.request.EditarSubcategoriaRequestDto;
import com.apirest.gestiondeinventario_backend.subcategoria.application.dto.request.EliminarSubcategoriaRequestDto;
import com.apirest.gestiondeinventario_backend.subcategoria.application.dto.response.InsertarSubcategoriaResponseDto;
import com.apirest.gestiondeinventario_backend.subcategoria.application.dto.response.ListarSubcategoriaResponseDto;
import com.apirest.gestiondeinventario_backend.subcategoria.application.dto.response.EditarSubcategoriaResponseDto;
import com.apirest.gestiondeinventario_backend.subcategoria.application.dto.response.EliminarSubcategoriaResponseDto;
import com.apirest.gestiondeinventario_backend.subcategoria.application.service.SubcategoriaApplicationService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/subcategorias")
public class SubcategoriaController {

    @Autowired
    private SubcategoriaApplicationService subcategoriaApplicationService;

    @PostMapping("")
    public ResponseEntity<BaseResponseDto> insertarSubcategoria(
        @RequestBody InsertarSubcategoriaRequestDto requestDto
    ){
        try {
            InsertarSubcategoriaResponseDto responseDto = subcategoriaApplicationService.insertarSubcategoria(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @GetMapping("")
    public ResponseEntity<BaseResponseDto> listarSubcategorias(){
        try {
            List<ListarSubcategoriaResponseDto> responseDtos = subcategoriaApplicationService.listarSubcategorias();
            return ResponseEntity.ok(BaseResponseDto.success(responseDtos));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @PutMapping("")
    public ResponseEntity<BaseResponseDto> editarSubcategoria(
       @Valid @RequestBody EditarSubcategoriaRequestDto requestDto
    ){
        try {
            EditarSubcategoriaResponseDto responseDto = subcategoriaApplicationService.editarSubcategoria(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @DeleteMapping("")
    public ResponseEntity<BaseResponseDto> eliminarSubcategoria(
       @Valid @RequestBody EliminarSubcategoriaRequestDto requestDto
    ){
        try {
            EliminarSubcategoriaResponseDto responseDto = subcategoriaApplicationService.eliminarSubcategoria(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }
}
