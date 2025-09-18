package com.apirest.gestiondeinventario_backend.categoria.application.dto.response;

import lombok.Data;

@Data
public class InsertarCategoriaResponseDto {
    
    private Integer idCategoria;
    private Integer codigo;
    private String nombre;

}
