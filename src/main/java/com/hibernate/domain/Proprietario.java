package com.hibernate.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Proprietario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome_proprietario", nullable = true)
	private String nome;
	@Column(name = "email_proprietario", nullable = true)
	private String email;
	
	@ElementCollection
	@CollectionTable(name = "proprietario_telefones",
	joinColumns = @JoinColumn(name = "cod_proprietario"))
	@AttributeOverrides({ @AttributeOverride(name = "numero",
	column = @Column(name = "num_telefone", length = 20, nullable = false)) })
	private List<Telefone> telefone = new ArrayList<>();
	
	@OneToMany()
	private List<Veiculo> veiculos = new ArrayList<>();
	
	public String getNome() {
		return nome;
	}
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Telefone> getTelefone() {
		return telefone;
	}
	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
