package com.hibernate.main2;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.hibernate.main.JpaUtil;

public class PersistindoAcessorios {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
	
		tx.begin();
		
		
	}

}
