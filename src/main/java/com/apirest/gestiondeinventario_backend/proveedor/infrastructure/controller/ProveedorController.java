package com.apirest.gestiondeinventario_backend.proveedor.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.apirest.gestiondeinventario_backend.common.application.dto.response.BaseResponseDto;
import com.apirest.gestiondeinventario_backend.proveedor.application.dto.request.EditarProveedorRequestDto;
import com.apirest.gestiondeinventario_backend.proveedor.application.dto.request.EliminarProveedorRequestDto;
import com.apirest.gestiondeinventario_backend.proveedor.application.dto.request.InsertarProveedorRequestDto;
import com.apirest.gestiondeinventario_backend.proveedor.application.dto.response.EditarProveedorResponseDto;
import com.apirest.gestiondeinventario_backend.proveedor.application.dto.response.EliminarProveedorResponseDto;
import com.apirest.gestiondeinventario_backend.proveedor.application.dto.response.InsertarProveedorResponseDto;
import com.apirest.gestiondeinventario_backend.proveedor.application.dto.response.ListarProveedorResponseDto;
import com.apirest.gestiondeinventario_backend.proveedor.application.service.ProveedorApplicationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorApplicationService proveedorApplicationService;

    @PostMapping("")
    public ResponseEntity<BaseResponseDto> insertarProveedor(
       @Valid @RequestBody InsertarProveedorRequestDto requestDto
    ) {
        try {
            InsertarProveedorResponseDto responseDto = proveedorApplicationService.insertarProveedor(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @PutMapping("")
    public ResponseEntity<BaseResponseDto> editarProveedor(
       @Valid @RequestBody EditarProveedorRequestDto requestDto
    ) {
        try {
            EditarProveedorResponseDto responseDto = proveedorApplicationService.editarProveedor(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @DeleteMapping("")
    public ResponseEntity<BaseResponseDto> eliminarProveedor(
       @Valid @RequestBody EliminarProveedorRequestDto requestDto
    ) {
        try {
            EliminarProveedorResponseDto responseDto = proveedorApplicationService.eliminarProveedor(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @GetMapping("")
    public ResponseEntity<BaseResponseDto> listarProveedores() {
        try {
            List<ListarProveedorResponseDto> proveedores = proveedorApplicationService.listarProveedores();
            return ResponseEntity.ok(BaseResponseDto.success(proveedores));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }
}
