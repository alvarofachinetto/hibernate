package com.hibernate.main8;

import javax.persistence.EntityManager;

import com.hibernate.main.JpaUtil;

public class Consulta {

	public static void main(String[] args) {
		EntityManager manager1 = JpaUtil.getEntityManager();
		CentroCusto centro1 = manager1.find(CentroCusto.class, 1L);
		System.out.println("Centro de custo: " + centro1.getNome());
		manager1.close();
		System.out.println("-----");
		EntityManager manager2 = JpaUtil.getEntityManager();
		CentroCusto centro2 = manager2.find(CentroCusto.class, 1L);
		System.out.println("Centro de custo: " + centro2.getNome());
		manager2.close();
		JpaUtil.close();

	}

}
