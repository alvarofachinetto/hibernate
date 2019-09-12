package com.hibernate.main;

import javax.persistence.EntityManager;

import com.hibernate.domain.Acessorio;
import com.hibernate.domain.Proprietario;
import com.hibernate.domain.Veiculo;

public class ListandoRelacionamento {
	
	public static void main(String[] args) {
		try {
			EntityManager manager = JpaUtil.getEntityManager();
			
//			Proprietario proprietario = manager.find(Proprietario.class, 2L);
//			
//			System.out.printf("%s", proprietario.getNome());
//			for (Veiculo veiculo : proprietario.getVeiculos()) {
//				System.out.printf("%s", veiculo.getModelo());
//			}
			
			Veiculo veiculo = manager.find(Veiculo.class, 2L);
			System.out.println("Veículo: " + veiculo.getModelo());
			
			for (Acessorio acessorio : veiculo.getAcessorios()) {
			System.out.println("Acessório: " + acessorio.getDescricao());
			}
			
			
			manager.close();
			JpaUtil.close();
		} catch (Exception e) {
			System.out.println("Deu merda ->"+ e);
		}
		
	}
	
}
