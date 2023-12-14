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
private Long id_restaurante;
@Column(length = 50, nullable = false)
private String nome_restaurante;
@Column(length = 15, nullable = false)
private String telefone_restaurante;
@Column(length = 100, nullable = false)
private String endereco;
@Column (length = 100, nullable = false)
private String descricao;
@OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL)
private List<Avaliacao> avaliacoes;



public Restaurante() {
	super();
}
public Restaurante(Long id_restaurante, String nome_restaurante, String telefone_restaurante, String endereco,
		String descricao) {
	super();
	this.id_restaurante = id_restaurante;
	this.nome_restaurante = nome_restaurante;
	this.telefone_restaurante = telefone_restaurante;
	this.endereco = endereco;
	this.descricao = descricao;
}
public Long getId_restaurante() {
	return id_restaurante;
}
public void setId_restaurante(Long id_restaurante) {
	this.id_restaurante = id_restaurante;
}
public String getNome_restaurante() {
	return nome_restaurante;
}
public void setNome_restaurante(String nome_restaurante) {
	this.nome_restaurante = nome_restaurante;
}
public String getTelefone_restaurante() {
	return telefone_restaurante;
}
public void setTelefone_restaurante(String telefone_restaurante) {
	this.telefone_restaurante = telefone_restaurante;
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
