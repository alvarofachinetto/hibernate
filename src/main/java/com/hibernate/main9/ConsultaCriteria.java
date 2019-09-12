package com.hibernate.main9;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.hibernate.domain.TipoCombustivel;
import com.hibernate.domain.Veiculo;
import com.hibernate.main.JpaUtil;

public class ConsultaCriteria {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		
//		CriteriaBuilder builder = manager.getCriteriaBuilder();
//		
//		CriteriaQuery<Veiculo> criteriaQuery = builder.createQuery(Veiculo.class);
//		
//		Root<Veiculo> veiculo = criteriaQuery.from(Veiculo.class);
//		criteriaQuery.select(veiculo);
//		
//		TypedQuery<Veiculo> query = manager.createQuery(criteriaQuery);
//		
//		List<Veiculo> veiculos = query.getResultList();
//		for (Veiculo v : veiculos) {
//			System.out.println(v.getModelo());
//		}
//		
//		filtros dinâmicos
//		CriteriaBuilder builder =
//				manager.getCriteriaBuilder();
//				CriteriaQuery<Veiculo> criteriaQuery = builder.createQuery(Veiculo.class);
//		
//		Root<Veiculo> veiculo = criteriaQuery.from(Veiculo.class);
//		Predicate predicate = builder.not(builder.equal(veiculo.get("tipoCombustivel"), TipoCombustivel.DIESEL));
//		criteriaQuery.select(veiculo);
//		criteriaQuery.where(predicate);
//		TypedQuery<Veiculo> query = manager.createQuery(criteriaQuery);
//		List<Veiculo> veiculos = query.getResultList();
//		for (Veiculo v : veiculos) {
//			System.out.println(v.getModelo());
//		}
		
//		List<Veiculo> veiculos = pesquisarVeiculos( TipoCombustivel.BIOCOMBUSTIVEL, new BigDecimal(50_000));
//		for (Veiculo v : veiculos) {
//			System.out.println(v.getModelo() + " - " + v.getValor());
//		}
		
//		Projeções
//		CriteriaBuilder builder = manager.getCriteriaBuilder();
//		CriteriaQuery<String> criteriaQuery = builder.createQuery(String.class);
//		Root<Veiculo> veiculo = criteriaQuery.from(Veiculo.class);
//		criteriaQuery.select(veiculo.<String>get("modelo"));
//		TypedQuery<String> query = manager.createQuery(criteriaQuery);
//		List<String> modelos = query.getResultList();
//		for (String modelo : modelos) {
//			System.out.println(modelo);
//		}
		
//		Função de Agregação
//		CriteriaBuilder builder = manager.getCriteriaBuilder();
//		CriteriaQuery<BigDecimal> criteriaQuery = builder.createQuery(BigDecimal.class);
//		Root<Veiculo> veiculo = criteriaQuery.from(Veiculo.class);
//		criteriaQuery.select(builder.sum(veiculo.<BigDecimal>get("valor")));
//		TypedQuery<BigDecimal> query = manager.createQuery(criteriaQuery);
//		BigDecimal total = query.getSingleResult();
//		System.out.println("Valor total: " + total);
		
//		Lista de Object[]
//		CriteriaBuilder builder = manager.getCriteriaBuilder();
//		CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
//		Root<Veiculo> veiculo = criteriaQuery.from(Veiculo.class);
//		criteriaQuery.multiselect(veiculo.<String>get("modelo"),
//		veiculo.<String>get("valor"));
//		TypedQuery<Object[]> query = manager.createQuery(criteriaQuery);
//		List<Object[]> resultado = query.getResultList();
//		for (Object[] valores : resultado) {
//			System.out.println(valores[0] + " - " + valores[1]);
//		}
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = builder.createTupleQuery();
		Root<Veiculo> veiculo = criteriaQuery.from(Veiculo.class);
		criteriaQuery.multiselect(veiculo.<String>get("modelo").alias("modeloVeiculo"),
		veiculo.<String>get("valor").alias("valorVeiculo"));
		TypedQuery<Tuple> query = manager.createQuery(criteriaQuery);
		List<Tuple> resultado = query.getResultList();
		for (Tuple tupla : resultado) {
			System.out.println(tupla.get("modeloVeiculo")
		+ " - " + tupla.get("valorVeiculo"));
		}
		
		manager.close();		
		JpaUtil.close();

	}
	
	public static List<Veiculo> pesquisarVeiculos(
			TipoCombustivel tipoCombustivel, BigDecimal maiorValor) {
			
			EntityManager manager = JpaUtil.getEntityManager();
			
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			
			CriteriaQuery<Veiculo> criteriaQuery = builder.createQuery(Veiculo.class);
			
			Root<Veiculo> veiculo = criteriaQuery.from(Veiculo.class);
			
			criteriaQuery.select(veiculo);
			
			List<Predicate> predicates = new ArrayList<>();
			
			if (tipoCombustivel != null) {
				ParameterExpression<TipoCombustivel> paramTipoCombustivel =
				builder.parameter(TipoCombustivel.class, "tipoCombustivel");
				predicates.add(builder.equal(veiculo.get("tipoCombustivel"),
					paramTipoCombustivel));
			}
			
			if (maiorValor != null) {
				ParameterExpression<BigDecimal> paramValor = builder.parameter(
					BigDecimal.class, "maiorValor");
				predicates.add(builder.lessThanOrEqualTo(
					veiculo.<BigDecimal>get("valor"), paramValor));
			}
			
			criteriaQuery.where(predicates.toArray(new Predicate[0]));
			
			TypedQuery<Veiculo> query = manager.createQuery(criteriaQuery);
			
			if (tipoCombustivel != null) {
				query.setParameter("tipoCombustivel", tipoCombustivel);
			}
			
			if (maiorValor != null) {
				query.setParameter("maiorValor", maiorValor);
			}
			
			List<Veiculo> veiculos = query.getResultList();
			manager.close();
			return veiculos;
		}

}
