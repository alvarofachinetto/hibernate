package com.hibernate.main7;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "animal")
@EntityListeners(AuditorAnimal.class) //está falando: olha vc precisa fazer isso antes de suas ações
public class Animal {

	private Long id;
	private String nome;
	private Date dataNascimento;
	private Date dataUltimaAtualizacao;
	private Integer idade;

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

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento", nullable = false)
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_ultima_atualizacao", nullable = false)
	public Date getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}

	@Transient
	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	@PostLoad
	@PostPersist
	@PostUpdate
	public void calcularIdade() {
		long idadeEmMillis = new Date().getTime() - this.getDataNascimento().getTime();
		this.setIdade((int) (idadeEmMillis / 1000d / 60 / 60 / 24 / 365));
	}

}
