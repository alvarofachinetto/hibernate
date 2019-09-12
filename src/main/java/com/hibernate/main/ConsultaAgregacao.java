package com.hibernate.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.hibernate.domain.Veiculo;

public class ConsultaAgregacao {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
//		TypedQuery<TotalCarroPorAno> query = manager.createQuery(
//				"select new com.algaworks.vo.TotalCarroPorAno(v.anoFabricacao, "
//				+ "avg(v.valor), count(v)) "
//				+ "from Veiculo v group by v.anoFabricacao", TotalCarroPorAno.class);
//		
//		List<TotalCarroPorAno> resultado = query.getResultList();
//		
//		resultado.forEach(valor -> System.out.println("Ano: " + valor.getAnoFabricacao()
//		+ " - Preço médio: " + valor.getMediaPreco()
//		+ " - Quantidade: " + valor.getQuantidadeCarros()));

		//		for (TotalCarroPorAno valores : resultado) {
//		System.out.println("Ano: " + valores.getAnoFabricacao()
//		+ " - Preço médio: " + valores.getMediaPreco()
//		+ " - Quantidade: " + valores.getQuantidadeCarros()
//		}
//		inner join
//		TypedQuery<Proprietario> query = manager.createQuery("select p from Proprietario p inner join p.veiculos v",
//		Proprietario.class);
//		List<Proprietario> proprietarios = query.getResultList();
//		
//		proprietarios.forEach(proprietario -> System.out.println(proprietario.getNome()));
//	
//		for (Proprietario proprietario : proprietarios) {
//			System.out.println(proprietario.getNome());
//		}
//		left join
//		TypedQuery<Object[]> query = manager.createQuery("select p.nome, count(v) from Proprietario p "
//		+ "inner join p.veiculos v group by p.nome", Object[].class);
//		List<Object[]> resultado = query.getResultList();
//		resultado.forEach(valores -> System.out.println(valores[0] + " - "+ valores[1]));
		
//		for (Object[] valores : resultado) {
//			System.out.println(valores[0] + " - " + valores[1]);
//		}
//		 problema n+1
//		TypedQuery<Veiculo> query = manager.
//				createQuery("from Veiculo v inner join fetch v.proprietario", Veiculo.class);
//
//		List<Veiculo> veiculos = query.getResultList();
//		veiculos.forEach(veiculo -> System.out.println(veiculo.getModelo()+" - "+veiculo.getProprietario().getNome()));
		//query nomeadas
//		TypedQuery<Veiculo> query = manager.createNamedQuery(
//		"Veiculo.comProprietarioPorValor", Veiculo.class);
//		query.setParameter("valor", new BigDecimal(10_000));
//		List<Veiculo> veiculos = query.getResultList();
//		for (Veiculo veiculo : veiculos) {
//			System.out.println(veiculo.getModelo() + " - "
//			+ veiculo.getProprietario().getNome());
//		}
//		
		Query query = manager.createNativeQuery("select * from veiculo",Veiculo.class);
		List<Veiculo> veiculos = query.getResultList();
		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo.getModelo() + " - "
			+ veiculo.getProprietario().getNome());
		}
		
		manager.close();
	}

}
