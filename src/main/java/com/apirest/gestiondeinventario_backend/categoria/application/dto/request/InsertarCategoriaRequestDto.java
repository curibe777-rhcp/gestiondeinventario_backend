package com.apirest.gestiondeinventario_backend.categoria.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class InsertarCategoriaRequestDto {

    @NotNull
    private Integer codigo;

    @NotBlank
    @Size(min = 1, max = 150)
    private String nombre;
}
