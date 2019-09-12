package com.hibernate.main2;

import javax.persistence.EntityManager;

import com.hibernate.domain.Proprietario;
import com.hibernate.domain.Telefone;
import com.hibernate.main.JpaUtil;

public class ConsultandoCollection {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		
		Proprietario proprietario = manager.find(Proprietario.class, 1L);
		
		System.out.println("Proprietário: " + proprietario.getNome());
		for (Telefone telefone : proprietario.getTelefone()) {
		System.out.println("Telefone: (" + telefone.getPrefixo() + ") "
		+ telefone.getNumero()
		+ (telefone.getRamal() != null ? " x" + telefone.getRamal() : ""));
		}
		manager.close();
		JpaUtil.close();

	}

}
