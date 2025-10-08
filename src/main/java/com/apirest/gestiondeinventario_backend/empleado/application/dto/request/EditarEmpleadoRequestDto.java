package com.apirest.gestiondeinventario_backend.empleado.application.dto.request;

import java.sql.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EditarEmpleadoRequestDto {

    @NotNull
    @Min(1)
    private Integer idEmpleado;

    @NotBlank
    @Size(min = 1, max = 100)
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$")
    private String nombre;

    @NotBlank
    @Size(min = 1, max = 100)
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$")
    private String apellidoPaterno;

    @NotBlank
    @Size(min = 1, max = 100)
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$")
    private String apellidoMaterno;

    @NotNull
    @Past
    private Date fechaNacimiento;

    @NotNull
    private Character tipoDocumento;

    @NotBlank
    @Pattern(regexp = "^[0-9]+$")
    private String numeroDocumento;

    @NotNull
    private Character genero;

    @NotNull
    private Character estadoCivil;

    @NotBlank
    @Size(min = 1, max = 100)
    private String direccion;

    @NotBlank
    @Size(min = 1, max = 50)
    private String distrito;
}
