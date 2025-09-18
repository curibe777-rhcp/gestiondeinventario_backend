package com.apirest.gestiondeinventario_backend.marca.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.gestiondeinventario_backend.marca.application.dto.request.InsertarMarcaRequestDto;
import com.apirest.gestiondeinventario_backend.marca.application.dto.response.InsertarMarcaResponseDto;
import com.apirest.gestiondeinventario_backend.marca.application.service.MarcaApplicationService;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    @Autowired
    private MarcaApplicationService marcaApplicationService;

    @PostMapping("")
    public ResponseEntity<InsertarMarcaResponseDto> insertarMarca(
        @RequestBody InsertarMarcaRequestDto requestDto
    ) {
        try {
            InsertarMarcaResponseDto responseDto = marcaApplicationService.insertarMarca(requestDto);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
