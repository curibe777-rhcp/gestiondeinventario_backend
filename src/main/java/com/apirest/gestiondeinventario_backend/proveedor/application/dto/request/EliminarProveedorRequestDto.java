package com.apirest.gestiondeinventario_backend.proveedor.application.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EliminarProveedorRequestDto {

    @NotNull
    @Min(1)
    private Integer idProveedor;
}
