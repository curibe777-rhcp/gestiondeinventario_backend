package com.apirest.gestiondeinventario_backend.categoria.domain.entities;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.Set;
import com.apirest.gestiondeinventario_backend.subcategoria.domain.entities.Subcategoria;

@Data
@Entity
@Table(name = "categoria")
public class Categoria {
    
    @Id
    @Column(name = "id_categoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;

    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private Set<Subcategoria> subcategorias;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion", insertable = false)
    private LocalDateTime fechaModificacion;

    @Column(name = "esdesactivado", insertable = false)
    private Integer esDesactivado;
}

