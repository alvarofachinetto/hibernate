package com.hibernate.main2;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.hibernate.domain.Veiculo;

public class Merge {

	public static void main(String[] args) {
		try {
//			EntityManager manager = JpaUtil.getEntityManager();
//			EntityTransaction tx = manager.getTransaction();
//			tx.begin();
//			Veiculo veiculo = manager.find(Veiculo.class, 2L);
//			tx.commit();
//			
//			manager.close();
//			veiculo.setValor(new BigDecimal(5000));
//			manager = JpaUtil.getEntityManager();
//			tx = manager.getTransaction();
//			tx.begin();
//			// reanexamos o objeto ao novo EntityManager
//			veiculo = manager.merge(veiculo);
//			tx.commit();
//			manager.close();
//			JpaUtil.close();
		} catch (Exception e) {
			System.out.println("Deu merda: "+ e.getMessage());
		}
		

	}

}
