package com.hibernate.heranca;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//@DiscriminatorValue("C")
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class Cliente extends Pessoa{
	
	private BigDecimal limiteCredito;
	private BigDecimal rendaMensal;
	private boolean bloqueado;
	
	@Column(name = "limite_credito", nullable = true)
	public BigDecimal getLimiteCredito() {
		return limiteCredito;
	}
	
	public void setLimiteCredito(BigDecimal limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	
	@Column(name = "renda_mensal", nullable = true)
	public BigDecimal getRendaMensal() {
		return rendaMensal;
	}
	
	public void setRendaMensal(BigDecimal rendaMensal) {
		this.rendaMensal = rendaMensal;
	}
	
	@Column(nullable = true)
	public boolean isBloqueado() {
	return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
	this.bloqueado = bloqueado;
	}
}
