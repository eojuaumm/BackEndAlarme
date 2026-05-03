package br.edu.uninassau.alarme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import br.edu.uninassau.alarme.entity.Historico;
import br.edu.uninassau.alarme.repository.HistoricoRepository;

@RestController
@RequestMapping("/historicos")
public class HistoricoController {

    @Autowired
    private HistoricoRepository historicoRepository;

    @PostMapping
    public ResponseEntity<String> criarHistorico(@RequestBody Historico historico) {
        historicoRepository.save(historico);
        return ResponseEntity.status(201).body("Registro de histórico salvo com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<Historico>> listarHistoricos() {
        return ResponseEntity.ok(historicoRepository.findAll());
    }
}