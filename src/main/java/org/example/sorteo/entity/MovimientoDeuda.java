package org.example.sorteo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "movimiento_deuda", indexes = {
        @Index(name = "idx_vendedor_fecha", columnList = "id_vendedor,fecha_movimiento")
})
public class MovimientoDeuda {
    @Id
    private Integer id_movimiento;

    private LocalDateTime fecha_movimiento;
    private String tipo_movimiento;
    private Integer cantidad_boletas;
    private BigDecimal valor_total;
    private BigDecimal valor_abono;
    private String observacion;

    @ManyToOne
    @JoinColumn(name = "id_vendedor")
    private Vendedor id_vendedor;
}
