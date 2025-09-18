package com.apirest.gestiondeinventario_backend.subcategoria.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import lombok.Data;

import java.time.LocalDateTime;
import com.apirest.gestiondeinventario_backend.categoria.domain.entities.Categoria;

@Data
@Entity
@Table(name = "subcategoria")
public class Subcategoria {
    
    @Id
    @Column(name = "id_subcategoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSubcategoria;

    @Column(name = "codigo", nullable = false)
    private Integer codigo;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion", insertable = false)
    private LocalDateTime fechaModificacion;

    @Column(name = "esdesactivado", insertable = false)
    private Character esDesactivado;
}
