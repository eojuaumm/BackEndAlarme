package br.edu.uninassau.alarme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.uninassau.alarme.entity.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
