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

import com.example.aula_final.entities.Restaurante;
import com.example.aula_final.repository.RestauranteRepository;

@CrossOrigin
@RestController
@RequestMapping ("/restaurantes")
public class RestauranteController {

	@Autowired
	RestauranteRepository repo;
	
	@GetMapping()
	public ResponseEntity<List<Restaurante>> getRestaurantes() {
		return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
	}
	
	@PostMapping()
	public ResponseEntity<Restaurante> inserirRestaurante(@RequestBody Restaurante restaurante){
		Restaurante ct = repo.save(restaurante);
		return ResponseEntity.status(HttpStatus.CREATED).body(ct);
	}
	
	@PutMapping("/{idrestaurante}")
	public ResponseEntity<Restaurante> alterarRestaurante(@PathVariable("idrestaurante")Long idrestaurante, @RequestBody Restaurante restaurante){
		Optional<Restaurante> opRestaurante = repo.findById(idrestaurante);
		try {
			Restaurante ct = opRestaurante.get();
			ct.setNome_restaurante(restaurante.getNome_restaurante());
			ct.setTelefone_restaurante(restaurante.getTelefone_restaurante());
			ct.setEndereco(restaurante.getEndereco());
			ct.setDescricao(restaurante.getDescricao());
			repo.save(ct);
			return ResponseEntity.status(HttpStatus.OK).body(restaurante);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Restaurante> getUmRestaurante (@PathVariable("id") long id) {
		Optional<Restaurante> opRestaurante = repo.findById(id);
		try {
			Restaurante ct = opRestaurante.get();
			return ResponseEntity.status(HttpStatus.OK).body(ct);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<Restaurante> deleteRestaurante (@PathVariable("id") long id) {
		Optional<Restaurante> opRestaurante = repo.findById(id);
		try {
			Restaurante ct = opRestaurante.get();
			repo.delete(ct);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
