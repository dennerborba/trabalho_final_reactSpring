package com.example.aula_final.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula_final.entities.Avaliacao;
import com.example.aula_final.repository.AvaliacaoRepository;

@CrossOrigin
@RestController
@RequestMapping ("/avaliacoes")
public class AvaliacaoController {
	@Autowired
	AvaliacaoRepository repo;
	
	@GetMapping()
	public ResponseEntity<List<Avaliacao>> getAvaliacao() {
		return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
	}
	
	@PostMapping()
	public ResponseEntity<Avaliacao> inserirAvaliacao(@RequestBody Avaliacao avaliacao){
		Avaliacao ct = repo.save(avaliacao);
		return ResponseEntity.status(HttpStatus.CREATED).body(ct);
	}
	
	@PutMapping("/{idavaliacao}")
	public ResponseEntity<Avaliacao> alterarAvaliacao(@PathVariable("idavaliacao")Long idavaliacao, @RequestBody Avaliacao avaliacao){
		Optional<Avaliacao> opAvaliacao = repo.findById(idavaliacao);
		try {
			Avaliacao ct = opAvaliacao.get();
			ct.setComentario(avaliacao.getComentario());
			ct.setClassificacao(avaliacao.getClassificacao());
			ct.setRestaurante(avaliacao.getRestaurante());
			repo.save(ct);
			return ResponseEntity.status(HttpStatus.OK).body(avaliacao);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Avaliacao> getUmaAvaliacao (@PathVariable("id") long id) {
		Optional<Avaliacao> opAvaliacao = repo.findById(id);
		try {
			Avaliacao ct = opAvaliacao.get();
			return ResponseEntity.status(HttpStatus.OK).body(ct);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<Avaliacao> deleteAvaliacao (@PathVariable("id") long id) {
		Optional<Avaliacao> opAvaliacao = repo.findById(id);
		try {
			Avaliacao ct = opAvaliacao.get();
			repo.delete(ct);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
