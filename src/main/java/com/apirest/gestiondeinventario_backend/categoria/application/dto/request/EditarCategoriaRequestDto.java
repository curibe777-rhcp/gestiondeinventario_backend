package com.apirest.gestiondeinventario_backend.categoria.application.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EditarCategoriaRequestDto {

    @NotNull
    @Min(1)
    private Integer idCategoria;

    @NotBlank
    @Size(min = 1, max = 150)
    private String nombre;
}
