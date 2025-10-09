package com.apirest.gestiondeinventario_backend.subcategoria.application.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EliminarSubcategoriaRequestDto {

    @NotNull
    @Min(1)
    private Integer idSubcategoria;
}
