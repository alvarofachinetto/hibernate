package com.hibernate.main4;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tarefa")
public class Tarefa {

	@Id
	@GeneratedValue //field access -> ele é acessado pelos atributos
	private Long id;
	@Column(length = 100, nullable = false)
	private String descricao;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dataLimite;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
//	@Column(length = 100, nullable = false) -> propertie access -> só é acessado pelo prope=riedade do atributp 
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataLimite() {
		return dataLimite;
	}
	public void setDataLimite(Date dataLimite) {
		this.dataLimite = dataLimite;
	}
}
