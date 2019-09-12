package com.hibernate.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.hibernate.domain.Veiculo;

public class ExcluindoValor {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Veiculo veiculo = manager.find(Veiculo.class, 1l);
		manager.remove(veiculo);
		
		tx.commit();
		manager.close();
		JpaUtil.close();

	}

}
