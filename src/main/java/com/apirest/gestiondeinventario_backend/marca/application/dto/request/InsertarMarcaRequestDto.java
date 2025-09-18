package com.apirest.gestiondeinventario_backend.marca.application.dto.request;

import lombok.Data;

@Data
public class InsertarMarcaRequestDto {
    private Integer idMarca;
    private String nombre;
}

