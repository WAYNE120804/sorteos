package org.example.sorteo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "boleta")
public class Boleta {

    @Id
    private Integer id_boleta;

    private BigDecimal valor_boleta;
    private String numero_boleta;


    @ManyToOne
    @JoinColumn(name = "id_vendedor")
    private Vendedor id_vendedor;
}
