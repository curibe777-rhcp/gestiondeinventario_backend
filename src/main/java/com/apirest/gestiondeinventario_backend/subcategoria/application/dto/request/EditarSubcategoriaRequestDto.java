package com.apirest.gestiondeinventario_backend.subcategoria.application.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EditarSubcategoriaRequestDto {

    @NotNull
    @Min(1)
    private Integer idSubcategoria;

    @NotNull
    private Integer codigo;

    @NotBlank
    @Size(min = 1, max = 100)
    private String nombre;

    @NotNull
    @Min(1)
    private Integer idCategoria;
}