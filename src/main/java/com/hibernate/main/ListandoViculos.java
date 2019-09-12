package com.hibernate.main;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.hibernate.domain.Veiculo;

public class ListandoViculos {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		Scanner scan = new Scanner(System.in);
//		Query query = manager.createQuery("from  Veiculo");
		
//		@SuppressWarnings("unchecked")
//		List<Veiculo> listVeiculos = manager.createQuery("from Veiculo", Veiculo.class).getResultList();
//		
//		listVeiculos
//			.forEach(veiculo -> System.out.printf("%s", veiculo.getDescricao()));
//		
		//recomendado para quando o user digitar as infos para a consulta
//		Query query = manager.createQuery("from Veiculo where anoFabricacao >= :ano and valor <= :preco");
//		query.setParameter("ano", 2009);
//		query.setParameter("preco", new BigDecimal(60_000));
//		List<Veiculo> veiculos = query.getResultList();
//		veiculos.forEach(veiculo -> System.out.println(veiculo.getModelo() + " " 
//		+ veiculo.getFabricante() + ": " + veiculo.getAnoFabricacao()));
		//		for (Object obj : veiculos) {
//			Veiculo veiculo = (Veiculo) obj;
//			System.out.println(veiculo.getModelo() + " " + veiculo.getFabricante()
//			+ ": " + veiculo.getAnoFabricacao());
//		}
		//usando TypedQuery o getResultList já retorna uma lista do tipo especifícado 
//		TypedQuery<Veiculo> consulta = manager.createQuery("from veiculo", Veiculo.class);
//		List<Veiculo> veiculos2 = consulta.getResultList();
//		
//		veiculos2.forEach(veiculo -> System.out.println(veiculo.getModelo() + " "+ 
//					veiculo.getFabricante() +":"+ veiculo.getFabricante()));
		
//		TypedQuery<Veiculo> query = manager.createQuery("from Veiculo", Veiculo.class);
//		query.setFirstResult(0);
//		query.setMaxResults(10); // -> paginação
//		List<Veiculo> veiculos = query.getResultList();
//		veiculos.forEach(veiculo -> System.out.println(veiculo.getFabricante()+
//				" "+veiculo.getModelo()+":"+veiculo.getAnoFabricacao()));
		
//		System.out.println("Registro por páginas");
//		int numeroDePaginas = scan.nextInt();
//		int numeroDapagina =0;
//		
//		TypedQuery<Veiculo> query = manager.createQuery("form veiculo", Veiculo.class);
//		do {
//			System.out.println("Número da página");
//			int registroPorPagina = scan.nextInt();
//			
//			if (numeroDapagina != 0) {
//				int primeiroRegistro = (numeroDapagina - 1) * registroPorPagina;
//				
//				query.setFirstResult(primeiroRegistro);
//				query.setMaxResults(registroPorPagina);
//				List<Veiculo> veiculos = query.getResultList();
//				for (Veiculo veiculo : veiculos) {
//				System.out.println(veiculo.getModelo() + " "
//				+ veiculo.getFabricante()
//				+ ": " + veiculo.getAnoFabricacao());
//				}
//			}
//			
//		}while(numeroDapagina !=0);
//		
//		TypedQuery<String> query = manager.createQuery("select modelo from Veiculo", String.class);
//		
//		List<String> modelos = query.getResultList();
//		
//		modelos.forEach(modelo -> System.out.println(modelo));
		
		TypedQuery<Object[]> query = manager.createQuery("select modelo, valor from Veiculo", Object[].class);
		
		List<Object[]> objs = query.getResultList();
		
		for (Object[] valores : objs) {
			String modelo = (String) valores[0];
			BigDecimal valor = (BigDecimal) valores[1];
			System.out.println(modelo + " - " + valor);
		}
		
		scan.close();		
		manager.close();
		JpaUtil.close();

	}

}
