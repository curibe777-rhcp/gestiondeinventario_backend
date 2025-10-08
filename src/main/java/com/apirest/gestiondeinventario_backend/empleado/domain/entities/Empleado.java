package com.apirest.gestiondeinventario_backend.empleado.domain.entities;

import java.sql.Date;
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
@Table(name = "empleado")
public class Empleado {

    @Id
    @Column(name = "id_empleado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpleado;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "ape_paterno")
    private String apellidoPaterno;

    @Column(name = "ape_materno")
    private String apellidoMaterno;

    @Column(name = "fecha_nac")
    private Date fechaNacimiento;

    @Column(name = "tipo_doc")
    private Character tipoDocumento;

    @Column(name = "num_doc")
    private String numeroDocumento;
    
    @Column(name = "genero")
    private Character genero;

    @Column(name = "estado_civil")
    private Character estadoCivil;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "distrito")
    private String distrito;

    @Column(name = "es_desactivado", insertable = false)
    private Integer esDesactivado;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion", insertable = false)
    private LocalDateTime fechaModificacion;

}
