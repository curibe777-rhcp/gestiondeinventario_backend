package com.apirest.gestiondeinventario_backend.empleado.application.dto.request;


import java.sql.Date;

import lombok.Data;

@Data
public class InsertarEmpleadoRequestDto {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private Character tipoDocumento;
    private String numeroDocumento;
    private Character genero;
    private Character estadoCivil;
    private String direccion;
    private String distrito;
}
