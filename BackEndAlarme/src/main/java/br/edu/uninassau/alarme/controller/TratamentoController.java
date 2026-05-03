package br.edu.uninassau.alarme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import br.edu.uninassau.alarme.entity.Tratamento;
import br.edu.uninassau.alarme.repository.TratamentoRepository;

@RestController
@RequestMapping("/tratamentos")
public class TratamentoController {

    @Autowired
    private TratamentoRepository tratamentoRepository;

    @PostMapping
    public ResponseEntity<String> criarTratamento(@RequestBody Tratamento tratamento) {
        tratamentoRepository.save(tratamento);
        return ResponseEntity.status(201).body("Tratamento agendado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<Tratamento>> listarTratamentos() {
        return ResponseEntity.ok(tratamentoRepository.findAll());
    }
}