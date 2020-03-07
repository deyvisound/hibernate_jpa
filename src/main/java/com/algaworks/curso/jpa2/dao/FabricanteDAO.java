package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

//o Serializable é utilizado pelo JSF
public class FabricanteDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager em;
	
	public Fabricante findByCodigo(Long primaryKey) {
		return em.find(Fabricante.class, primaryKey);
	}
	
	@SuppressWarnings("unchecked")
	public List<Fabricante> buscarTodos() {
		return em.createQuery("FROM Fabricante").getResultList();
	}

	// Notação criada nas classes UTIL
	@Transactional
	public void salvar(Fabricante fabricante) {
		em.persist(fabricante);
	}

	@Transactional
	public void excluir(Fabricante fabricante) {
		// "atachando" o objeto ao entintyManager
		fabricante = this.findByCodigo(fabricante.getCodigo());
		
		em.remove(fabricante);
		em.flush();
	}

	@Transactional
	public void atualizar(Fabricante fabricante) {
		em.merge(fabricante);		
	}
	
}
