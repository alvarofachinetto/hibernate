package com.hibernate.main2;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.hibernate.domain.Proprietario;
import com.hibernate.domain.Telefone;
import com.hibernate.main.JpaUtil;

public class ArmazenandoColection {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Proprietario proprietario = new Proprietario();
		proprietario.setNome("Sebastião");
		proprietario.setEmail("sebastiao.asda@gmail.com");
		proprietario.getTelefone().add(new Telefone("35", "1234-567-874", "104"));
		proprietario.getTelefone().add(new Telefone("36", "658-4545-444", "103"));
//		
		manager.persist(proprietario);
		tx.commit();
		manager.close();
		JpaUtil.close();
	}
}
