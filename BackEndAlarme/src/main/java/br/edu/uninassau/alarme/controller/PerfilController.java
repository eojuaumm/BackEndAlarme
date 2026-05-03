package br.edu.uninassau.alarme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import br.edu.uninassau.alarme.entity.Perfil;
import br.edu.uninassau.alarme.repository.PerfilRepository;

@RestController
@RequestMapping("/perfis")
public class PerfilController {

    @Autowired
    private PerfilRepository perfilRepository;

    @PostMapping
    public ResponseEntity<String> criarPerfil(@RequestBody Perfil perfil) {
        perfilRepository.save(perfil);
        return ResponseEntity.status(201).body("Perfil criado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<Perfil>> listarPerfis() {
        return ResponseEntity.ok(perfilRepository.findAll());
    }
}