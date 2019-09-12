package com.hibernate.heranca;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "pessoa")
//InheritanceType.SINGLE_TABLE -> as infos serão armazenadas em pessoa (há uma composição)
//InheritanceType.JOINED  -> as infos serão passadas através da fk em referencia a pk da tabela pai
//InheritanceType.TABLE_PER_CLASS -> cada tablea terá as infos da tabela pai 
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "tipo")
public abstract class Pessoa {
	
	@Id
	@GeneratedValue(generator = "inc")//Não podemos usar a geração automática de chaves nativa do banco de dados.
	@GenericGenerator(name = "inc", strategy = "increment")
	private Long id;
	
	@Column(length = 100, nullable = false)
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
