package com.apirest.gestiondeinventario_backend.marca.application.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class InsertarMarcaRequestDto {

    @NotNull
    @Min(1)
    private Integer idMarca;

    @NotBlank
    @Size(min = 1, max = 100)
    private String nombre;
}

