package com.hibernate.main;

import javax.persistence.EntityManager;

import com.hibernate.domain.Veiculo;

public class CriarTabelas1 {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		
//		Veiculo veiculo = manager.find(Veiculo.class, 1L);
//só executa o SQL quando o primeiro método getter for chamado
		Veiculo veiculo = manager.getReference(Veiculo.class, 1l);
		
		System.out.printf("Código: %d%nModelo: %s", veiculo.getId(), veiculo.getModelo());
		
		manager.close();
		JpaUtil.close();
	}
}
