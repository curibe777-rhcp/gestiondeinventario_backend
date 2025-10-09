package com.apirest.gestiondeinventario_backend.marca.application.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EliminarMarcaRequestDto {

    @NotNull
    @Min(1)
    private Integer idMarca;
}