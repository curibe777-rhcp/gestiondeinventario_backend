package com.apirest.gestiondeinventario_backend.empleado.application.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EliminarEmpleadoRequestDto {
    
    @NotNull
    @Min(1)
    private Integer idEmpleado;
}
