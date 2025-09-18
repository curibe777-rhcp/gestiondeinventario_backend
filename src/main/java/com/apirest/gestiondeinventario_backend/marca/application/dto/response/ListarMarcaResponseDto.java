package com.apirest.gestiondeinventario_backend.marca.application.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ListarMarcaResponseDto {
    private Integer idMarca;
    private String nombre;
    private LocalDateTime fechaCreacion;
}
