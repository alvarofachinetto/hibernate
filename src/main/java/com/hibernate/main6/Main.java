package com.hibernate.main6;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.hibernate.main.JpaUtil;

public class Main {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Usuario u1 = new Usuario();
		u1.setEmail("joao@algaworks.com");
		u1.setAtivo(true);
		Usuario u2 = new Usuario();
		u2.setEmail("manoel@algaworks.com");
		u2.setAtivo(true);
		Usuario u3 = new Usuario();
		u3.setEmail("sebastiao123@gmail.com");
		u3.setAtivo(true);
		manager.persist(u1);
		manager.persist(u2);
		manager.persist(u3);
		
		manager.close();
		JpaUtil.close();
	}
}
