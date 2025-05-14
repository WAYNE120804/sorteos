package org.example.sorteo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "abono")
public class Abono {
    @Id
    private Integer id_abono;

    private LocalDateTime fecha_abono;
    private BigDecimal valor_abono;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_vendedor")
    private Vendedor id_vendedor;
}