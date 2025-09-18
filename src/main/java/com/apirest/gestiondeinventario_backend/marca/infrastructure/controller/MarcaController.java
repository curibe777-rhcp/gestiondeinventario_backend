package com.apirest.gestiondeinventario_backend.marca.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.gestiondeinventario_backend.marca.application.dto.request.EditarMarcaRequestDto;
import com.apirest.gestiondeinventario_backend.marca.application.dto.request.EliminarMarcaRequestDto;
import com.apirest.gestiondeinventario_backend.marca.application.dto.request.InsertarMarcaRequestDto;
import com.apirest.gestiondeinventario_backend.marca.application.dto.response.EditarMarcaResponseDto;
import com.apirest.gestiondeinventario_backend.marca.application.dto.response.EliminarMarcaResponseDto;
import com.apirest.gestiondeinventario_backend.marca.application.dto.response.InsertarMarcaResponseDto;
import com.apirest.gestiondeinventario_backend.marca.application.dto.response.ListarMarcaResponseDto;
import com.apirest.gestiondeinventario_backend.marca.application.service.MarcaApplicationService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    @Autowired
    private MarcaApplicationService marcaApplicationService;

    @PostMapping("")
    public ResponseEntity<InsertarMarcaResponseDto> insertarMarca(
        @RequestBody InsertarMarcaRequestDto requestDto
    ){
        try {
            InsertarMarcaResponseDto responseDto = marcaApplicationService.insertarMarca(requestDto);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("")
    public ResponseEntity<EditarMarcaResponseDto> editarMarca(
        @RequestBody EditarMarcaRequestDto requestDto
    ){
        EditarMarcaResponseDto responseDto = marcaApplicationService.editarMarca(requestDto);

        if (responseDto != null) {
            return ResponseEntity.ok(responseDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("")
    public ResponseEntity<EliminarMarcaResponseDto> eliminarMarca(
        @RequestBody EliminarMarcaRequestDto requestDto
    ){
        try {
            EliminarMarcaResponseDto responseDto = marcaApplicationService.eliminarMarca(requestDto);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<ListarMarcaResponseDto>> listarMarcas(){
        List<ListarMarcaResponseDto> marcas = marcaApplicationService.listarMarcas();
        return ResponseEntity.ok(marcas);
    }
}
