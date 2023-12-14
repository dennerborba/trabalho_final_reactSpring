package com.example.aula_final.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_avaliacao")
public class Avaliacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_avaliacao;
	@Column(length = 255, nullable = false)
	private String comentario;
	@Column(length = 5, nullable = false)
	private int classificacao;
	@ManyToOne
	@JoinColumn(name = "restaurante_id", nullable = false)
	private Restaurante restaurante;

	public Long getId_avaliacao() {
		return id_avaliacao;
	}

	public void setId_avaliacao(Long id_avaliacao) {
		this.id_avaliacao = id_avaliacao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public Avaliacao(Long id_avaliacao, String comentario, int classificacao, Restaurante restaurante) {
		this.id_avaliacao = id_avaliacao;
		this.comentario = comentario;
		this.classificacao = classificacao;
		this.restaurante = restaurante;
	}

	public Avaliacao() {
		super();
	}

}
