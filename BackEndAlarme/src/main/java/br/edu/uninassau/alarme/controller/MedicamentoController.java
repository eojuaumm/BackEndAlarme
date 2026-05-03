package br.edu.uninassau.alarme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import br.edu.uninassau.alarme.entity.Medicamento;
import br.edu.uninassau.alarme.repository.MedicamentoRepository;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @PostMapping
    public ResponseEntity<Medicamento> criar(@RequestBody Medicamento medicamento) {
        return ResponseEntity.status(201).body(medicamentoRepository.save(medicamento));
    }

    @GetMapping
    public ResponseEntity<List<Medicamento>> listar() {
        return ResponseEntity.ok(medicamentoRepository.findAll());
    }
}