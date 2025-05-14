package org.example.sorteo.service;

import org.example.sorteo.entity.Boleta;
import org.example.sorteo.entity.Vendedor;
import org.example.sorteo.repository.BoletaRepository;
import org.example.sorteo.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoletaService {

    @Autowired
    private BoletaRepository boletaRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    private final BigDecimal VALOR_BOLETA = new BigDecimal("10000");

    @Transactional
    public String generarBoletasIniciales() {
        if (boletaRepository.count() > 0) {
            throw new RuntimeException("Ya existen boletas. No se pueden crear nuevamente.");
        }

        List<Boleta> boletas = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Boleta boleta = new Boleta();
            boleta.setId_boleta(i);
            boleta.setNumero_boleta(String.format("%04d", i));
            boleta.setValor_boleta(VALOR_BOLETA);
            boleta.setId_vendedor(null);
            boletas.add(boleta);
        }
        boletaRepository.saveAll(boletas);
        return "Se generaron 10,000 boletas exitosamente.";
    }

    @Transactional
    public void asignarBoletasAVendedor(List<Integer> idsBoletas, Integer idVendedor) {
        Optional<Vendedor> vendedorOpt = vendedorRepository.findById(idVendedor);
        if (vendedorOpt.isEmpty()) {
            throw new RuntimeException("Vendedor no encontrado con id: " + idVendedor);
        }

        Vendedor vendedor = vendedorOpt.get();
        List<Boleta> boletas = boletaRepository.findAllById(idsBoletas);

        for (Boleta boleta : boletas) {
            boleta.setId_vendedor(vendedor);
        }

        boletaRepository.saveAll(boletas);
    }

    public List<Boleta> findAll() {
        return boletaRepository.findAll();
    }

    public List<Boleta> findByVendedorId(Integer idVendedor) {
        return boletaRepository.findById_vendedor_Id_vendedor(idVendedor);
    }
}
