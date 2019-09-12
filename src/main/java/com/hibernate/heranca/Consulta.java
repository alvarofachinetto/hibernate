package com.hibernate.heranca;

import java.util.List;

import javax.persistence.EntityManager;

import com.hibernate.main.JpaUtil;

public class Consulta {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		
		List<Cliente> clientes = manager.createQuery("from Cliente", Cliente.class).getResultList();
		
		clientes.forEach(cliente -> System.out.println(cliente.getNome() + "-" + cliente.getRendaMensal()));
		List<Pessoa> pessoas = manager.createQuery("from Pessoa",
				Pessoa.class).getResultList();
		
		pessoas.stream()
			.filter(pessoa -> (pessoa instanceof Cliente))
			.forEach(pessoa -> System.out.println(pessoa.getNome() + " é um Cliente"));
	
		pessoas.stream()
		.filter(pessoa -> (pessoa instanceof Funcionario))
		.forEach(pessoa -> System.out.println(pessoa.getNome() + " é um Funcionario"));
	
		
//		for (Pessoa pessoa : pessoas) {
//			System.out.print(pessoa.getNome());
//			if (pessoa instanceof Cliente) {
//			System.out.println(" - é um cliente");
//			} else {
//			System.out.println(" - é um funcionário");
//			}
//		}
		
//		for (Cliente cliente : clientes) {
//			System.out.println(cliente.getNome() + " - " + cliente.getRendaMensal());
//		}
		manager.close();
		JpaUtil.close();
	}

}
