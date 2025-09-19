package com.apirest.gestiondeinventario_backend.subcategoria.application.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ListarSubcategoriaResponseDto {
    private Integer idSubcategoria;
    private Integer codigo;
    private String nombre;
    private LocalDateTime fechaCreacion;
}
