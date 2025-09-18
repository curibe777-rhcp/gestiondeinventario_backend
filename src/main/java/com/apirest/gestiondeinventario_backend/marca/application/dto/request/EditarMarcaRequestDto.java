package com.apirest.gestiondeinventario_backend.marca.application.dto.request;

import lombok.Data;

@Data
public class EditarMarcaRequestDto {
    private Integer idMarca;
    private String nombre;
}
