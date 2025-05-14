package org.example.sorteo.service;

import jakarta.transaction.Transactional;
import org.example.sorteo.entity.Vendedor;
import org.example.sorteo.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    // crear vendedor
    @Transactional
    public Vendedor saveVendedor(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    //buscar
    public Vendedor findById(int id) {
        Optional<Vendedor> vendedor = vendedorRepository.findById(id);

        if (vendedor.isEmpty()) {
            throw new RuntimeException("Vendedor not found");
        }
        return vendedor.get();
    }

    //mostrar todos
    public List<Vendedor> findAll() {
        return vendedorRepository.findAll();
    }

    // actualizar
    public Vendedor updateVendedor(Vendedor vendedor) {
        Optional<Vendedor> dbVendedor = vendedorRepository.findById(vendedor.getId_vendedor());

        if (dbVendedor.isEmpty()) {
            throw new RuntimeException("Vendedor not found");
        }

        Vendedor existingVendedor = dbVendedor.get();

        existingVendedor.setNombre_vendedor(vendedor.getNombre_vendedor());
        existingVendedor.setTelefono_vendedor(vendedor.getTelefono_vendedor());
        existingVendedor.setDireccion_vendedor(vendedor.getDireccion_vendedor());
        existingVendedor.setCedula_vendedor(vendedor.getCedula_vendedor());
        existingVendedor.setComision_vendedor(vendedor.getComision_vendedor());
        existingVendedor.setApodo_vendedor(vendedor.getApodo_vendedor());

        return vendedorRepository.save(existingVendedor);
    }


    //borrar
    public void deleteVendedor(int id) {
        Optional<Vendedor> dbVendedor = vendedorRepository.findById(id);

        if (dbVendedor.isEmpty()) {
            throw new RuntimeException("Vendedor not found");
        }

        vendedorRepository.delete(dbVendedor.get());
    }
}
