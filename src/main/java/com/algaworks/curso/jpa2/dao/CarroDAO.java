package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Carro;

public class CarroDAO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	EntityManager em;

	public void salvar(Carro carro) {
		em.persist(carro);
	}

	public Carro findByCodigo(Long primaryKey) {
		return em.find(Carro.class, primaryKey);
	}
	
	@SuppressWarnings("unchecked")
	public List<Carro> findAll(){
		String jpql = "FROM Carro";		
		return em.createQuery(jpql).getResultList();
	}

}
