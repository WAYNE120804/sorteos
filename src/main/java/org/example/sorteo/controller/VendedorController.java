package org.example.sorteo.controller;

import org.example.sorteo.entity.Vendedor;
import org.example.sorteo.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @PostMapping("/save")
    public Vendedor save(@RequestBody Vendedor vendedor) {
        return vendedorService.saveVendedor(vendedor);
    }

    @GetMapping("/findAll")
    public List<Vendedor> findAll() {
        return vendedorService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Vendedor findById(@PathVariable int id) {
        return vendedorService.findById(id);
    }

    @PostMapping("/update")
    public Vendedor update(@RequestBody Vendedor vendedor) {
        return vendedorService.updateVendedor(vendedor);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable int id) {
        vendedorService.deleteVendedor(id);
    }
}
