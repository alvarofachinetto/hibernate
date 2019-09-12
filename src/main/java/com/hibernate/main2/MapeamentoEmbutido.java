package com.hibernate.main2;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.hibernate.domain.Proprietario;
import com.hibernate.domain.Telefone;
import com.hibernate.main.JpaUtil;

public class MapeamentoEmbutido {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Proprietario proprietario = new Proprietario();
		proprietario.setNome("Bastista");
		proprietario.setEmail("batista.das@gmail.com");
		proprietario.getTelefone().add(new Telefone("34", "1234-5678", "104"));
//		proprietario.getTelefone().add(new Telefone("11", "9876-5432", null));
		manager.persist(proprietario);
		tx.commit();
		manager.close();
		JpaUtil.close();
	}

}
