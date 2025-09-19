package com.apirest.gestiondeinventario_backend.subcategoria.application.dto.response;

import lombok.Data;

@Data
public class EditarSubcategoriaResponseDto {
    private Integer idSubcategoria;
    private Integer codigo;
    private String nombre;
}
