package com.example.aula_final.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "tb_restaurante")

public class Restaurante {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Long idRestaurante;
@Column(length = 50, nullable = false)
private String nome;
@Column(length = 15, nullable = false)
private String telefone;
@Column(length = 100, nullable = false)
private String endereco;
@Column (length = 100, nullable = false)
private String descricao;
@OneToMany(mappedBy = "Restaurante", cascade = CascadeType.ALL)
private List<Avaliacao> avaliacoes;



public Restaurante() {
	super();
}
public Restaurante(Long idRestaurante, String nome, String telefone, String endereco,
		String descricao) {
	super();
	this.idRestaurante = idRestaurante;
	this.nome = nome;
	this.telefone= telefone;
	this.endereco = endereco;
	this.descricao = descricao;
}
public Long getIdRestaurante() {
	return idRestaurante;
}
public void setIdRestaurante(Long idRestaurante) {
	this.idRestaurante = idRestaurante;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome= nome;
}
public String getTelefone() {
	return telefone;
}
public void setTelefone(String telefone) {
	this.telefone = telefone;
}
public String getEndereco() {
	return endereco;
}
public void setEndereco(String endereco) {
	this.endereco = endereco;
}
public String getDescricao() {
	return descricao;
}
public void setDescricao(String descricao) {
	this.descricao = descricao;
}
}
