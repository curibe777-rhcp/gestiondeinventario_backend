package com.apirest.gestiondeinventario_backend.categoria.application.dto.request;

import lombok.Data;

@Data
public class EditarCategoriaRequestDto {
    private Integer idCategoria;
    private String nombre;
}
