package com.hibernate.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tab_veiculo")
@NamedQuery(name = "Veiculo.comProprietarioPorValor",
query = "from Veiculo v "
+ "inner join fetch v.proprietario where v.valor > :valor")
public class Veiculo {
	@Id
	@GeneratedValue(generator  = "inc") //sem strategy, por padrão será auto
	@GenericGenerator(name="inc", strategy = "increment")
	@Column(name = "cod_veiculo")
	private Long id;
//	@EmbeddedId
//	private VeiculoID veiculoID;
//	
	@Column(length = 60, nullable = false)
	private String fabricante;
	@Column(length = 60, nullable = false)
	private String modelo;
	@Column(name = "nome_fabricacao", nullable = false)
	private Integer anoFabricacao;
	@Column(name = "ano_modelo", nullable = false)
	private Integer anoModelo;
	@Column(precision = 10, scale = 2, nullable = true)
	private BigDecimal valor;
	@Column(name = "tipo_combustivel", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoCombustivel tipoCombustivel;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_cadastro", nullable = false)
	private Date dataCadastro;
	@Lob
	private String especificacoes;
//	@Embedded
//	@OneToOne
	@ManyToOne()
	@JoinColumn(name = "cod_proprietario")
	private Proprietario proprietario;
	
	@ManyToMany
	@JoinTable(name = "veiculos_acessorios", joinColumns = @JoinColumn(name="codVeiculo"), 
	inverseJoinColumns = @JoinColumn(name="codAcessorio"))
	private Set<Acessorio> acessorios;
	
//	public VeiculoID getVeiculoID() {
//		return veiculoID;
//	}
//	public void setVeiculoID(VeiculoID veiculoID) {
//		this.veiculoID = veiculoID;
//	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public Integer getAnoModelo() {
		return anoModelo;
	}
	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Veiculo() {}
	
	
	public TipoCombustivel getTipoCombustivel() {
		return tipoCombustivel;
	}
	public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}
	
	@Transient
	public String getDescricao() {
		return this.getFabricante() + " " + this.getModelo()
		+ " " + this.getAnoFabricacao() + "/" + this.getAnoModelo()+
		" por "+ this.getValor();
	}
	public String getEspecificacoes() {
		return especificacoes;
	}
	public void setEspecificacoes(String especificacoes) {
		this.especificacoes = especificacoes;
	}
	public Proprietario getProprietario() {
		return proprietario;
	}
	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	public Set<Acessorio> getAcessorios() {
		return acessorios;
	}
	public void setAcessorios(Set<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}
	public Veiculo(String fabricante, String modelo, Integer anoFabricacao, Integer anoModelo, BigDecimal valor,
			TipoCombustivel tipoCombustivel, Date dataCadastro, String especificacoes, Proprietario proprietario,
			Set<Acessorio> acessorios) {
		super();
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
		this.valor = valor;
		this.tipoCombustivel = tipoCombustivel;
		this.dataCadastro = dataCadastro;
		this.especificacoes = especificacoes;
		this.proprietario = proprietario;
		this.acessorios = acessorios;
	}
	
	
	
}
