package com.hibernate.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.hibernate.domain.Veiculo;

public class AtualizandoVeiculo {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Veiculo veiculo = manager.find(Veiculo.class, 1l);
		
		System.out.printf("Valor: %f", veiculo.getValor());
		veiculo.setValor(veiculo.getValor().add(new BigDecimal(500)));
		System.out.printf("Atualizando valor: %f", veiculo.getValor());
		
		tx.commit();
		manager.close();
		JpaUtil.close();

	}

}
