package com.hibernate.main7;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.hibernate.main.JpaUtil;

public class Main {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Animal animal = new Animal();
		animal.setNome("Mimosa");		
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.set(2009, 8, 20);
		animal.setNome("Campeão");
		animal.setDataNascimento(dataNascimento.getTime());
	
		System.out.println("Idade antes de persistir: " + animal.getIdade());
		manager.persist(animal);
		System.out.println("Idade depois de persistir: " + animal.getIdade());
		
		tx.commit();
		manager.close();
		JpaUtil.close();

	}

}
