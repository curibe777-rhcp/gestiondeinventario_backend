package com.apirest.gestiondeinventario_backend.subcategoria.application.dto.request;

import lombok.Data;

@Data
public class EditarSubcategoriaRequestDto {
    private Integer idSubcategoria;
    private Integer codigo;
    private String nombre;
    private Integer idCategoria;
}