package com.apirest.gestiondeinventario_backend.proveedor.application.dto.response;

import lombok.Data;

@Data
public class ListarProveedorResponseDto {
    private Integer idProveedor;
    private Character tipoDocumento;
    private String numeroDocumento;
    private String razonSocial;
    private String nombreComercial;
    private String contacto;
    private String telefono;
    private String direccion;
    private String distrito;
}
