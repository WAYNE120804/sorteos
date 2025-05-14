package org.example.sorteo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "premio")
public class Premio {
    @Id
    private Integer id_premio;

    private String nombre_premio;
    private String descripcion_premio;

    @Column(name = "valor_premio")
    private BigDecimal valor_premio;
    private String destino_sorteo;

    @ManyToOne
    @JoinColumn(name = "id_sorteo")
    private Sorteo _id_sorteo;
}
