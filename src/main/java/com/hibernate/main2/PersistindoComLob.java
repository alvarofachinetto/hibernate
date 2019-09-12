package com.hibernate.main2;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.hibernate.domain.Acessorio;
import com.hibernate.domain.TipoCombustivel;
import com.hibernate.domain.Veiculo;
import com.hibernate.main.JpaUtil;

public class PersistindoComLob {
	public static void main(String[] args) {
		try {
			EntityManager manager = JpaUtil.getEntityManager();
			EntityTransaction tx = manager.getTransaction();
			tx.begin();
			
			Acessorio alarme = new Acessorio();
			alarme.setCodigo(1l);
			alarme.setDescricao("Alarme");
			Acessorio arCondicionado = new Acessorio();
			arCondicionado.setCodigo(2l);
			arCondicionado.setDescricao("Ar condicionado");
			Acessorio bancosDeCouro = new Acessorio();
			bancosDeCouro.setCodigo(3l);
			bancosDeCouro.setDescricao("Bancos de couro");
			Acessorio direcaoHidraulica = new Acessorio();
			direcaoHidraulica.setCodigo(4l);
			direcaoHidraulica.setDescricao("Direção hidráulica");
			
			List<Acessorio> listAcessorios = Arrays.asList(alarme, arCondicionado, bancosDeCouro, direcaoHidraulica);
			
			listAcessorios.stream()
			.forEach(acessorio -> manager.persist(acessorio));
			
			
//			Proprietario proprietario = new Proprietario();
//			proprietario.setNome("João das Couves");
//			proprietario.setTelefone("(34) 1234-5678");
//			proprietario.setEmail("joao.couvas@gmail.com");
			
//			manager.persist(proprietario);
			
			Veiculo veiculo1 = new Veiculo();
			veiculo1.setFabricante("GM");
			veiculo1.setModelo("Celta");
			veiculo1.setAnoFabricacao(2006);
			veiculo1.setAnoModelo(2006);
			veiculo1.setValor(new BigDecimal(11000));
			veiculo1.setTipoCombustivel(TipoCombustivel.GASOLINA);
			veiculo1.setDataCadastro(new Date());
//			veiculo1.setProprietario(proprietario);
			veiculo1.getAcessorios().add(alarme);
			veiculo1.getAcessorios().add(arCondicionado);
			
			Veiculo veiculo2 = new Veiculo();
			veiculo2.setFabricante("VW");
			veiculo2.setModelo("Gol");
			veiculo2.setAnoFabricacao(2010);
			veiculo2.setAnoModelo(2010);
			veiculo2.setValor(new BigDecimal(17200));
			veiculo2.setTipoCombustivel(TipoCombustivel.BIOCOMBUSTIVEL);
			veiculo2.setDataCadastro(new Date());
//			veiculo2.setProprietario(proprietario);
			veiculo2.getAcessorios().add(arCondicionado);
			veiculo2.getAcessorios().add(bancosDeCouro);
			veiculo2.getAcessorios().add(direcaoHidraulica);
			
			manager.persist(veiculo1);
			manager.persist(veiculo2);
			
			tx.commit();
			manager.close();
			JpaUtil.close();
		} catch (Exception e) {
			System.out.println("Erro -> "+ e.getMessage());
			e.printStackTrace();
		}

	}
}
