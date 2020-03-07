package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Aluguel;
import com.algaworks.curso.jpa2.modelo.ApoliceSeguro;

public class AluguelDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;	 
	
	public void salvar(Aluguel aluguel) {
		ApoliceSeguro apoliceSeguro = aluguel.getApoliceSeguro();
		
		em.persist(apoliceSeguro);		
		em.persist(aluguel);		
	}
	
	public Aluguel findByCodigo(Long id) {
		return em.find(Aluguel.class, id);
	}

}
