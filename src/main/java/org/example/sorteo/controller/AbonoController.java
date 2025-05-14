package org.example.sorteo.controller;

import org.example.sorteo.entity.Abono;
import org.example.sorteo.service.AbonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abono")
public class AbonoController {

    @Autowired
    private AbonoService abonoService;

    @PostMapping("/save")
    public Abono save(@RequestBody Abono abono) {
        return abonoService.saveAbono(abono);
    }

    @GetMapping("/findAll")
    public List<Abono> findAll() {
        return abonoService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Abono findById(@PathVariable int id) {
        return abonoService.findById(id);
    }

    @PutMapping("/update")
    public Abono update(@RequestBody Abono abono) {
        return abonoService.updateAbono(abono);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable int id) {
        abonoService.deleteAbono(id);
    }
}
