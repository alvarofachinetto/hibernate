package com.hibernate.main2;

import javax.persistence.EntityManager;

import com.hibernate.domain.Proprietario;
import com.hibernate.main.JpaUtil;

public class ListandoCollection {
	
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
//		
//		Proprietario proprietario = manager.find(Proprietario.class, 1l);
//		
//		System.out.println("Nome"+ proprietario.getNome());
//		for (String telefone : proprietario.getTelefone()) {
//			System.out.println("Telefone"+telefone);
//		}
		
		manager.clear();
		manager.close();
		JpaUtil.close();
	}
}
