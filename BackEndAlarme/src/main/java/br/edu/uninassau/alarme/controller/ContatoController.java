package br.edu.uninassau.alarme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import br.edu.uninassau.alarme.entity.Contato;
import br.edu.uninassau.alarme.repository.ContatoRepository;

@RestController
public class ContatoController {
	@Autowired
    private ContatoRepository contatoRepository;
	
	@PostMapping("/contato")
	public ResponseEntity<String> criarContato(@RequestBody Contato contato) {
		contatoRepository.save(contato);
		return ResponseEntity.status(201).body("Contato criado com sucesso!");
	}	

	@GetMapping("/contato")
	public ResponseEntity<List<Contato>> getContato() {
	    return ResponseEntity.ok(contatoRepository.findAll());
	}
	
	@PutMapping("/contato/{id}")
	public ResponseEntity<String> putContato(@PathVariable Long id, @RequestBody Contato updatedContato) {
		return contatoRepository.findById(id).map(contato -> {
	        contato.setNome(updatedContato.getNome());
	        contato.setEmail(updatedContato.getEmail());
	        contatoRepository.save(contato);
	        return ResponseEntity.ok("Contato atualizado com sucesso!");
	    }).orElse(ResponseEntity.notFound().build());
	}
	

	@DeleteMapping("/contato/{id}")
	public ResponseEntity<Void> deleteContato(@PathVariable Long id) {
		   if (contatoRepository.existsById(id)) {
		        contatoRepository.deleteById(id);
		        return ResponseEntity.noContent().build();
		    }
		    return ResponseEntity.notFound().build();
	}

}
