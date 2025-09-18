package com.apirest.gestiondeinventario_backend.producto.application.dto.request;

import lombok.Data;

@Data
public class InsertarProductoRequestDto {
    private String sku;
    private String codigoBarras;
    private String nombre;
    private Integer idSubcategoria;
    private Integer idMarca;
    private double precioCosto;
    
}
