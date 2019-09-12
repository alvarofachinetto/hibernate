package com.hibernate.teste;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.hibernate.main.JpaUtil;

public class Teste {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		
		Pessoa amanda = new Pessoa();
		Pessoa clara = new Pessoa();
		
		amanda.setNome("asdasdasda");
		clara.setNome("Clara");
		List<Pessoa> pessoas = Arrays.asList(amanda, clara);
		pessoas.forEach(pessoa -> manager.persist(pessoa));
		
		Trabalho bombeiro = new Trabalho();
		bombeiro.setNome("Bombeiro");
		
		List<Trabalho> trabalhos = Arrays.asList(bombeiro);
		trabalhos.forEach(trabalho -> manager.persist(bombeiro));
		
		
		amanda.setTrabalhos(trabalhos);
		bombeiro.setFuncionarios(pessoas);
		
		transaction.commit();
		manager.close();
		JpaUtil.close();
	}

}
