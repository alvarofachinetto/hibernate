package com.hibernate.main2;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.hibernate.domain.Acessorio;
import com.hibernate.domain.TipoCombustivel;
import com.hibernate.domain.Veiculo;
import com.hibernate.main.JpaUtil;

public class PersistindoRelacionamento {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		// instancia acessórios
		Acessorio alarme = new Acessorio();
		alarme.setDescricao("Alarme");
		Acessorio arCondicionado = new Acessorio();
		arCondicionado.setDescricao("Ar condicionado");
		Acessorio bancosDeCouro = new Acessorio();
		bancosDeCouro.setDescricao("Bancos de couro");
		Acessorio direcaoHidraulica = new Acessorio();
		direcaoHidraulica.setDescricao("Direção hidráulica");
		Set<Acessorio> listAcessorio = new HashSet<Acessorio>(Arrays.asList(alarme, arCondicionado,
				bancosDeCouro, direcaoHidraulica));
		// persiste acessórios
		listAcessorio.stream()
			.forEach(acessorio -> manager.persist(acessorio));
		
//		// instancia veículos
		Veiculo veiculo1 = new Veiculo();
		veiculo1.setFabricante("VW");
		veiculo1.setModelo("Gol");
		veiculo1.setAnoFabricacao(2010);
		veiculo1.setAnoModelo(2010);
		veiculo1.setValor(new BigDecimal(17_200));
		veiculo1.setTipoCombustivel(TipoCombustivel.BIOCOMBUSTIVEL);
		veiculo1.setDataCadastro(new Date());
		veiculo1.setAcessorios(listAcessorio);
		
		Veiculo veiculo2 = new Veiculo();
		veiculo2.setFabricante("Hyundai");
		veiculo2.setModelo("i30");
		veiculo2.setAnoFabricacao(2012);
		veiculo2.setAnoModelo(2012);
		veiculo2.setValor(new BigDecimal(53_500));
		veiculo2.setTipoCombustivel(TipoCombustivel.BIOCOMBUSTIVEL);
		veiculo2.setDataCadastro(new Date());
		veiculo2.getAcessorios().add(alarme);
		veiculo2.getAcessorios().add(arCondicionado);
		veiculo2.getAcessorios().add(bancosDeCouro);
		veiculo2.getAcessorios().add(direcaoHidraulica);
		veiculo2.getAcessorios().add(direcaoHidraulica);
		// persiste veículos
		List<Veiculo> listVeiculos = Arrays.asList(veiculo1, veiculo2);
		listVeiculos.stream()
			.forEach(veiculo -> manager.persist(veiculo));
		
		
		tx.commit();
		manager.close();
		JpaUtil.close();

	}

}
