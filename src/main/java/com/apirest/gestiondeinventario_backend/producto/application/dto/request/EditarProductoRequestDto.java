package com.apirest.gestiondeinventario_backend.producto.application.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EditarProductoRequestDto {

    @NotNull
    @Min(1)
    private Integer idProducto;

    @NotBlank
    @Size(min = 1, max = 150)
    private String sku;

    @NotBlank
    @Size(min = 1, max = 150)
    private String codigoBarras;

    @NotBlank
    @Size(min = 1, max = 100)
    private String nombre;

    @NotNull
    @Min(1)
    private Integer idSubcategoria;

    @NotNull
    @Min(1)
    private Integer idMarca;

    @NotNull
    @Min(1)
    private double precioCosto;
}
