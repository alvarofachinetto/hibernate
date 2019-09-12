package com.hibernate.domain;

public class TotalCarroPorAno {

	private Integer anoFabricacao;
	private Double mediaPreco;
	private Long quantidadeCarros;
	
	public TotalCarroPorAno(Integer anoFabricacao, Double mediaPreco, Long quantidadeCarros) {
		super();
		this.anoFabricacao = anoFabricacao;
		this.mediaPreco = mediaPreco;
		this.quantidadeCarros = quantidadeCarros;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Double getMediaPreco() {
		return mediaPreco;
	}

	public void setMediaPreco(Double mediaPreco) {
		this.mediaPreco = mediaPreco;
	}

	public Long getQuantidadeCarros() {
		return quantidadeCarros;
	}

	public void setQuantidadeCarros(Long quantidadeCarros) {
		this.quantidadeCarros = quantidadeCarros;
	}
	
	
}
