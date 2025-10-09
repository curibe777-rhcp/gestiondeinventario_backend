package com.apirest.gestiondeinventario_backend.marca.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.gestiondeinventario_backend.common.application.dto.response.BaseResponseDto;
import com.apirest.gestiondeinventario_backend.marca.application.dto.request.EditarMarcaRequestDto;
import com.apirest.gestiondeinventario_backend.marca.application.dto.request.EliminarMarcaRequestDto;
import com.apirest.gestiondeinventario_backend.marca.application.dto.request.InsertarMarcaRequestDto;
import com.apirest.gestiondeinventario_backend.marca.application.dto.response.EditarMarcaResponseDto;
import com.apirest.gestiondeinventario_backend.marca.application.dto.response.EliminarMarcaResponseDto;
import com.apirest.gestiondeinventario_backend.marca.application.dto.response.InsertarMarcaResponseDto;
import com.apirest.gestiondeinventario_backend.marca.application.dto.response.ListarMarcaResponseDto;
import com.apirest.gestiondeinventario_backend.marca.application.service.MarcaApplicationService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    @Autowired
    private MarcaApplicationService marcaApplicationService;

    @PostMapping("")
    public ResponseEntity<BaseResponseDto> insertarMarca(
       @Valid @RequestBody InsertarMarcaRequestDto requestDto
    ){
        try {
            InsertarMarcaResponseDto responseDto = marcaApplicationService.insertarMarca(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @PutMapping("")
    public ResponseEntity<BaseResponseDto> editarMarca(
       @Valid @RequestBody EditarMarcaRequestDto requestDto
    ){
        try {
            EditarMarcaResponseDto responseDto = marcaApplicationService.editarMarca(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
        
        
    }

    @DeleteMapping("")
    public ResponseEntity<BaseResponseDto> eliminarMarca(
       @Valid @RequestBody EliminarMarcaRequestDto requestDto
    ){
        try {
            EliminarMarcaResponseDto responseDto = marcaApplicationService.eliminarMarca(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @GetMapping("")
    public ResponseEntity<BaseResponseDto> listarMarcas(){
        try{
            List<ListarMarcaResponseDto> responseDto = marcaApplicationService.listarMarcas();
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch(Exception e){
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
        
    }
}
