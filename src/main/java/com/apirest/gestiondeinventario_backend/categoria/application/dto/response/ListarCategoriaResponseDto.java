package com.apirest.gestiondeinventario_backend.categoria.application.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ListarCategoriaResponseDto {
    private Integer idCategoria;
    private Integer codigo;
    private String nombre;
    private LocalDateTime fechaCreacion;
}
