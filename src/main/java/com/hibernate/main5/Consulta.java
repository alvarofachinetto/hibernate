package com.hibernate.main5;

import javax.persistence.EntityManager;

import com.hibernate.main.JpaUtil;

public class Consulta {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		Produto produto = manager.find(Produto.class, 3L);
		System.out.println("Nome: " + produto.getNome());
		manager.close();
		JpaUtil.close();

	}

}
