package org.example.sorteo.repository;


import org.example.sorteo.entity.Boleta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoletaRepository extends JpaRepository<Boleta, Integer> {
    List<Boleta> findById_vendedor_Id_vendedor(Integer idVendedor);
}
