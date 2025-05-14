package org.example.sorteo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "informacion_sorteo")
public class InformacionSorteo {
    @Id
    private Integer id_info_sorteo;
    private String nombre_sorteo;
    private String descripcion_sorteo;
    private Date fecha_incio;
    private Date fecha_final;
}
