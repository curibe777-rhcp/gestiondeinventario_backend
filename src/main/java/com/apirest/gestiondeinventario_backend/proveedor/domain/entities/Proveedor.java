package com.apirest.gestiondeinventario_backend.proveedor.domain.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Integer idProveedor;

    @Column(name = "tipo_doc")
    private Character tipoDocumento;

    @Column(name = "num_doc")
    private String numeroDocumento;

    @Column(name = "razon_social", nullable = false, length = 150)
    private String razonSocial;

    @Column(name = "nombre_comercial", length = 150)
    private String nombreComercial;

    @Column(name = "contacto", length = 100)
    private String contacto;

    @Column(name = "telefono", length = 50)
    private String telefono;

    @Column(name = "direccion", length = 100)
    private String direccion;

    @Column(name = "distrito", length = 50)
    private String distrito;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion", insertable = false)
    private LocalDateTime fechaModificacion;

    @Column(name = "es_desactivado", insertable = false)
    private Integer esDesactivado;
}
