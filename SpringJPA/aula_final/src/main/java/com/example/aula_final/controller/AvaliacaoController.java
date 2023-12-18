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
import com.example.aula_final.entities.Restaurante;
import com.example.aula_final.repository.AvaliacaoRepository;
import com.example.aula_final.repository.RestauranteRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/restaurantes/{idRestaurante}/avaliacoes")
public class AvaliacaoController {
	@Autowired
	AvaliacaoRepository repo;
	@Autowired
	RestauranteRepository restauranteRepository;


	@GetMapping()
	public ResponseEntity<List<Avaliacao>> obterAvaliacoes(@PathVariable Long idRestaurante) {
	    List<Avaliacao> avaliacoes = repo.findByRestauranteIdRestaurante(idRestaurante);
	    return ResponseEntity.ok(avaliacoes);
	}

	@PostMapping()
    public ResponseEntity<Avaliacao> inserirAvaliacao(@PathVariable Long idRestaurante, @RequestBody Avaliacao avaliacao) {

        Restaurante restaurante = new Restaurante();
        restaurante.setIdRestaurante(idRestaurante);
        avaliacao.setRestaurante(restaurante);

        Avaliacao avaliacaoSalva = repo.save(avaliacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacaoSalva);
    }

	@PutMapping("/{idAvaliacao}")
	public ResponseEntity<Avaliacao> alterarAvaliacao(@PathVariable("idRestaurante") Long idRestaurante,@PathVariable("idAvaliacao") Long idAvaliacao,@RequestBody Avaliacao avaliacao) {
		Optional<Avaliacao> opAvaliacao = repo.findById(idAvaliacao);
		try {
			Avaliacao ct = opAvaliacao.get();
			ct.setComentario(avaliacao.getComentario());
			ct.setClassificacao(avaliacao.getClassificacao());
			repo.save(ct);
			return ResponseEntity.status(HttpStatus.OK).body(avaliacao);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("/{idAvaliacao}")
    public ResponseEntity<Avaliacao> obterAvaliacaoPorId(@PathVariable("idRestaurante") Long idRestaurante,@PathVariable("idAvaliacao") Long idAvaliacao) {

        Optional<Avaliacao> opAvaliacao = repo.findById(idAvaliacao);
        return opAvaliacao.map(avaliacao ->
                ResponseEntity.ok(avaliacao)
        ).orElseGet(() ->
                ResponseEntity.notFound().build()
        );
    }
	

	@DeleteMapping("/{idAvaliacao}")
	public ResponseEntity<Void> deleteAvaliacao(@PathVariable("idRestaurante") Long idRestaurante,@PathVariable("idAvaliacao") Long idAvaliacao) {

	    Optional<Avaliacao> opAvaliacao = repo.findById(idAvaliacao);

	    try {
	        Avaliacao ct = opAvaliacao.orElseThrow();
	        repo.delete(ct);
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	}
}
