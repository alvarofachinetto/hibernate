package com.hibernate.heranca;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.hibernate.main.JpaUtil;

public class Main {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Fernando");
		funcionario.setCargo("Gerente");
		funcionario.setSalario(new BigDecimal(12_000));
		
		Cliente cliente = new Cliente();
		cliente.setNome("Mariana");
		cliente.setRendaMensal(new BigDecimal(8_500));
		cliente.setLimiteCredito(new BigDecimal(2_000));
		cliente.setBloqueado(true);
		
		manager.persist(funcionario);
		manager.persist(cliente);
		
		tx.commit();
		manager.close();
		JpaUtil.close();

	}

}
