package com.apirest.gestiondeinventario_backend.categoria.application.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EliminarCategoriaRequestDto {

    @NotNull
    @Min(1)
    private Integer idCategoria;
}
