package com.apirest.gestiondeinventario_backend.proveedor.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class InsertarProveedorRequestDto {

    @NotNull
    private Character tipoDocumento;

    @NotBlank
    @Pattern(regexp = "^[0-9]+$")
    private String numeroDocumento;

    @NotBlank
    @Size(min = 1, max = 150)
    private String razonSocial;

    @NotBlank
    @Size(min = 1, max = 150)
    private String nombreComercial;

    @NotBlank
    @Size(min = 1, max = 100)
    private String contacto;

    @NotBlank
    @Size(min = 1, max = 50)
    @Pattern(regexp = "^[0-9]+$")
    private String telefono;

    @NotBlank
    @Size(min = 1, max = 100)
    private String direccion;

    @NotBlank
    @Size(min = 1, max = 50)
    private String distrito;
}
