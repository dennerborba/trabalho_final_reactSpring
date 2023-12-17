package com.example.aula_final.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aula_final.entities.Avaliacao;



@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{
	List<Avaliacao> findByRestauranteId(Long idRestaurante);
}
