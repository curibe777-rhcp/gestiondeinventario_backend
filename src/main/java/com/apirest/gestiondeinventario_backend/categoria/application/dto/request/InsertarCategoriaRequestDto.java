package com.apirest.gestiondeinventario_backend.categoria.application.dto.request;

import lombok.Data;

@Data
public class InsertarCategoriaRequestDto {
    private Integer codigo;
    private String nombre;
}
