package com.hibernate.main;

import javax.persistence.EntityManager;

import com.hibernate.domain.Veiculo;


public class Listar {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		
		
//		VeiculoID id = new VeiculoID("ABC-1234","Uberlandia");
//		Veiculo veiculo = manager.find(Veiculo.class, id);
////		System.out.println("Placa: " + veiculo.getVeiculoID().getPlaca());
////		System.out.println("Cidade: " + veiculo.getVeiculoID().getCidade());
////		System.out.println("Fabricante: " + veiculo.getFabricante());
////		System.out.println("Modelo: " + veiculo.getModelo());
//		
////		Veiculo veiculo = manager.find(Veiculo.class, 1L);
//		System.out.println(veiculo.getDescricao());
		
//		System.out.printf("Placa: %d%nCidade: %d%nFabricante: %s%nModelo: %s%n", veiculo.getVeiculoID().getPlaca()
//				, veiculo.getVeiculoID().getCidade(), veiculo.getFabricante(), veiculo.getModelo());

	}

}
