package com.hibernate.main8;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.hibernate.main.JpaUtil;

public class Main {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		CentroCusto cc1 = new CentroCusto();
		cc1.setNome("Tecnologia");
		CentroCusto cc2 = new CentroCusto();
		cc2.setNome("Comercial");
		manager.persist(cc1);
		manager.persist(cc2);
		tx.commit();
		manager.close();
		JpaUtil.close();
	}

}
