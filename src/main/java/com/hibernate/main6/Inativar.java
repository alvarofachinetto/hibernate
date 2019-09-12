package com.hibernate.main6;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.hibernate.main.JpaUtil;

public class Inativar {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		Query query = manager.createQuery("update Usuario set ativo = false where email like :email");
		query.setParameter("email", "%@algaworks.com");
		int linhasAfetadas = query.executeUpdate();
		System.out.println(linhasAfetadas + " registros atualizados.");
		tx.commit();
		manager.close();
		JpaUtil.close();

	}

}
