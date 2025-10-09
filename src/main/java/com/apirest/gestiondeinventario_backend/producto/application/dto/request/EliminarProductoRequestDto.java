package com.apirest.gestiondeinventario_backend.producto.application.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EliminarProductoRequestDto {

    @NotNull
    @Min(1)
    private Integer idProducto;
}
