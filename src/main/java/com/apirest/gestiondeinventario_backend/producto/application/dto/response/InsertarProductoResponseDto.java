package com.apirest.gestiondeinventario_backend.producto.application.dto.response;

import lombok.Data;

@Data
public class InsertarProductoResponseDto {
    private Integer idProducto;
    private String sku;
    private String codigoBarras;
    private String nombre;
    private Integer idSubcategoria;
    private Integer idMarca;
    private double precioCosto;
}
