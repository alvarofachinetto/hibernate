package com.hibernate.main2;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.hibernate.domain.Proprietario;
import com.hibernate.domain.TipoCombustivel;
import com.hibernate.domain.Veiculo;
import com.hibernate.main.JpaUtil;

public class PersistindoVeiculos {
	public static void main(String[] args) {
		//obtém o entity manager
		EntityManager manager = JpaUtil.getEntityManager();
		//inicia a transação
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Proprietario proprietario = new Proprietario();
		proprietario.setNome("João das Couves");
//		proprietario.getTelefone().add("(34) 1234-5678");
//		proprietario.getTelefone().add("(11) 9876-5432");
		proprietario.setEmail("joao.couves@gmail.com");
		manager.persist(proprietario);
		
//		StringBuilder especificacoes = new StringBuilder();
//		especificacoes.append("Carro em excelente estado.\n");
//		especificacoes.append("Completo, menos ar.\n");
//		especificacoes.append("Primeiro dono, com manual de instrução ");
//		especificacoes.append("e todas as revisões feitas.\n");
//		especificacoes.append("IPVA pago, aceita financiamento.");
		
		Veiculo veiculo = new Veiculo();
		veiculo.setId(2L);
//		(new VeiculoID("Uberlandia","ABC-1234"));
		veiculo.setFabricante("Honda");
		veiculo.setModelo("Civic");
		veiculo.setAnoFabricacao(2012);
		veiculo.setAnoModelo(2013);
		veiculo.setEspecificacoes("sdfsdfsdff");
		veiculo.setValor(new BigDecimal(71300));
		veiculo.setTipoCombustivel(TipoCombustivel.BIOCOMBUSTIVEL);
		veiculo.setDataCadastro(new Date());
		veiculo.setProprietario(proprietario);
		manager.persist(veiculo);
		
		
		Veiculo veiculo1 = new Veiculo();
		veiculo1.setId(3L);
//		(new VeiculoID("Uberlandia","ABC-1234"));
		veiculo1.setFabricante("Honda");
		veiculo1.setModelo("Civic");
		veiculo1.setAnoFabricacao(2012);
		veiculo1.setAnoModelo(2013);
		veiculo1.setValor(new BigDecimal(71300));
		veiculo1.setEspecificacoes("sdfsdfsdff");
		veiculo1.setTipoCombustivel(TipoCombustivel.BIOCOMBUSTIVEL);
		veiculo1.setDataCadastro(new Date());
		veiculo1.setProprietario(proprietario);
		manager.persist(veiculo1);
		//efetua a inserção de dados no banco
		tx.commit();
		//fecha o JPA
		manager.close();
		JpaUtil.close();
		
	}
}
