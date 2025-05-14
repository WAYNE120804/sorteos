package org.example.sorteo.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class sorteoxboletasxinfo implements Serializable {

    private Integer fk_sorteo;
    private Integer fk_boleta;
    private Integer fk_info_sorteo;

}
