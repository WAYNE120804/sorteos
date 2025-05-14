package org.example.sorteo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "vendedor")
public class Vendedor {
    @Id
    private Integer id_vendedor;

    private String nombre_vendedor;
    private String telefono_vendedor;
    private String direccion_vendedor;
    private String cedula_vendedor;
    private BigDecimal comision_vendedor;
    private String apodo_vendedor;
}