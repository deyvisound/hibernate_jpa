package com.algaworks.curso.jpa2.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Carro;

public class CarroDAO {
	
	@Inject
	EntityManager em;

	public void salvar(Carro carro) {
		em.persist(carro);
	}

	public Carro findByCodigo(Long primaryKey) {
		return em.find(Carro.class, primaryKey);
	}

}
