package com.apirest.gestiondeinventario_backend.categoria.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.gestiondeinventario_backend.categoria.application.dto.request.EditarCategoriaRequestDto;
import com.apirest.gestiondeinventario_backend.categoria.application.dto.request.EliminarCategoriaRequestDto;
import com.apirest.gestiondeinventario_backend.categoria.application.dto.request.InsertarCategoriaRequestDto;
import com.apirest.gestiondeinventario_backend.categoria.application.dto.response.EditarCategoriaResponseDto;
import com.apirest.gestiondeinventario_backend.categoria.application.dto.response.EliminarCategoriaResponseDto;
import com.apirest.gestiondeinventario_backend.categoria.application.dto.response.InsertarCategoriaResponseDto;
import com.apirest.gestiondeinventario_backend.categoria.application.dto.response.ListarCategoriaResponseDto;
import com.apirest.gestiondeinventario_backend.categoria.application.service.CategoriaApplicationService;
import com.apirest.gestiondeinventario_backend.common.application.dto.response.BaseResponseDto;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaApplicationService categoriaApplicationService;
    
    @PostMapping("")
    public ResponseEntity<BaseResponseDto> insertarCategoria(
       @Valid @RequestBody InsertarCategoriaRequestDto requestDto
    ){
        try {
            InsertarCategoriaResponseDto responseDto = categoriaApplicationService.insertarCategoria(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }



    @PutMapping("")
    public ResponseEntity<BaseResponseDto> editarCategoria(
       @Valid @RequestBody EditarCategoriaRequestDto requestDto
    ){
        try {
            EditarCategoriaResponseDto responseDto = categoriaApplicationService.editarCategoria(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto)); 
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }  
    }

    @DeleteMapping("")
    public ResponseEntity<BaseResponseDto> eliminarCategoria(
       @Valid @RequestBody EliminarCategoriaRequestDto requestDto
    ){
        try{
            EliminarCategoriaResponseDto responseDto = categoriaApplicationService.eliminarCategoria(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        }catch(Exception e){
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }


    @GetMapping("")
    public ResponseEntity<BaseResponseDto> listarCategorias(){
        try {
            List<ListarCategoriaResponseDto> responseDto = categoriaApplicationService.listarCategorias();
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }



}
