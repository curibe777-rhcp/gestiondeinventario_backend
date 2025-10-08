package com.apirest.gestiondeinventario_backend.empleado.infrastructure.controller;

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
import com.apirest.gestiondeinventario_backend.empleado.application.dto.request.EditarEmpleadoRequestDto;
import com.apirest.gestiondeinventario_backend.empleado.application.dto.request.EliminarEmpleadoRequestDto;
import com.apirest.gestiondeinventario_backend.empleado.application.dto.request.InsertarEmpleadoRequestDto;
import com.apirest.gestiondeinventario_backend.empleado.application.dto.response.EditarEmpleadoResponseDto;
import com.apirest.gestiondeinventario_backend.empleado.application.dto.response.EliminarEmpleadoResponseDto;
import com.apirest.gestiondeinventario_backend.empleado.application.dto.response.InsertarEmpleadoResponseDto;
import com.apirest.gestiondeinventario_backend.empleado.application.dto.response.ListarEmpleadosResponseDto;
import com.apirest.gestiondeinventario_backend.empleado.application.service.EmpleadoApplicationService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    
    @Autowired
    private EmpleadoApplicationService empleadoApplicationService;


    @PostMapping("")
    public ResponseEntity<BaseResponseDto> insertarEmpleado(
       @Valid @RequestBody InsertarEmpleadoRequestDto requestDto
    ){
        try {
            InsertarEmpleadoResponseDto responseDto = empleadoApplicationService.insertarEmpleado(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @PutMapping("")
    public ResponseEntity<BaseResponseDto> editarEmpleado(
       @Valid @RequestBody EditarEmpleadoRequestDto requestDto
    ){
        try {
            EditarEmpleadoResponseDto responseDto = empleadoApplicationService.editarEmpleado(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @DeleteMapping("")
    public ResponseEntity<BaseResponseDto> eliminarEmpleado(
       @Valid @RequestBody EliminarEmpleadoRequestDto requestDto
    ){
        try {
            EliminarEmpleadoResponseDto responseDto = empleadoApplicationService.eliminarEmpleado(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @GetMapping("")
    public ResponseEntity<BaseResponseDto> listarEmpleados(){
        try{
            List<ListarEmpleadosResponseDto> responseDto = empleadoApplicationService.listarEmpleados();
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch(Exception e){
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
        
    }

}
