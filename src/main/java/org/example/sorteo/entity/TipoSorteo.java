package org.example.sorteo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;




@Entity
@Getter
@Setter

@Table(name = "tipo_sorteo")
public class TipoSorteo {

    @Id
    private Integer id_tipo_sorteo;
    private String nombre;
    private String descripcion;


}
