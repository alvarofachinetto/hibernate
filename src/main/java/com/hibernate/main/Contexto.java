package com.hibernate.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.hibernate.domain.Veiculo;

public class Contexto {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
//		Veiculo veiculo1 = manager.find(Veiculo.class, 1l); 
//		System.out.println("Buscou pela primeira vez");
//		
//		System.out.println("Gerenciado ? "+ manager.contains(veiculo1));
//		manager.detach(veiculo1);
//		System.out.println("Agora ? "+ manager.contains(veiculo1));
//		
//		Veiculo veiculo2 = manager.find(Veiculo.class, 1l); 
//		System.out.println("Buscou pela segunda vez");
//		
//		System.out.println("Mesmo veiculo ?"+ (veiculo1 == veiculo2));
		
		Veiculo veiculo = new Veiculo();
		veiculo.setFabricante("adasd");
		veiculo.setModelo("asd");
		veiculo.setAnoFabricacao(2013);
		veiculo.setAnoModelo(2014);
		veiculo.setValor(new BigDecimal(71200));
		
		veiculo = manager.find(Veiculo.class, 1L);
		System.out.println("Veiculo 1 "+ veiculo.getValor());
		
		System.out.printf("%d, %s", veiculo.getId(), veiculo.getModelo());
		
		veiculo.setValor(veiculo.getValor().add(new BigDecimal(700)));
		
		manager.flush(); //força uma sincronização antes mesmo do commit
		
		System.out.println("Novo Valor: "+ veiculo.getValor());
		
		tx.commit();
		manager.close();
		JpaUtil.close();
	}

}
