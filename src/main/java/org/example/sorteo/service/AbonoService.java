package org.example.sorteo.service;

import org.example.sorteo.entity.Abono;
import org.example.sorteo.repository.AbonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AbonoService {

    @Autowired
    private AbonoRepository abonoRepository;

    public Abono saveAbono(Abono abono) {
        abono.setFecha_abono(LocalDateTime.now());  // 🕒 Aquí se establece la fecha y hora actual
        return abonoRepository.save(abono);
    }

    public Abono findById(int id) {
        Optional<Abono> abono = abonoRepository.findById(id);
        if (abono.isEmpty()) {
            throw new RuntimeException("Abono not found");
        }
        return abono.get();
    }

    public List<Abono> findAll() {
        return abonoRepository.findAll();
    }

    public Abono updateAbono(Abono abono) {
        Optional<Abono> dbAbono = abonoRepository.findById(abono.getId_abono());
        if (dbAbono.isEmpty()) {
            throw new RuntimeException("Abono not found");
        }

        Abono existing = dbAbono.get();
        existing.setValor_abono(abono.getValor_abono());
        existing.setDescripcion(abono.getDescripcion());
        existing.setId_vendedor(abono.getId_vendedor());
        // No se actualiza la fecha: se mantiene como la original
        return abonoRepository.save(existing);
    }

    public void deleteAbono(int id) {
        Optional<Abono> abono = abonoRepository.findById(id);
        if (abono.isEmpty()) {
            throw new RuntimeException("Abono not found");
        }
        abonoRepository.delete(abono.get());
    }
}
