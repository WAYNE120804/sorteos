package org.example.sorteo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Entity
@Getter
@Setter
@Table(name = "sorteo")
public class Sorteo {
    @Id
    private Integer id_sorteo;

    private Date fecha_juego;

    @ManyToOne
    @JoinColumn(name = "id_premio")
    private Premio fk_premio;

    @ManyToOne
    @JoinColumn(name = "id_tipo_sorteo")
    private tipoSorteo fk_tipo_sorteo;
}
