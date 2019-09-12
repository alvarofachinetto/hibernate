package com.hibernate.main8;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "centro_custo")
@Cacheable(true)
public class CentroCusto {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	@Id
	@GeneratedValue
	public Long getId() {
	return id;
	}
	public void setId(Long id) {
	this.id = id;
	}
	@Column(length = 60, nullable = false)
	public String getNome() {
	return nome;
	}
	public void setNome(String nome) {
	this.nome = nome;
	}
}
