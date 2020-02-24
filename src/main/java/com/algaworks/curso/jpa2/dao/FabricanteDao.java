package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Fabricante;

//o Serializable é utilizado pelo JSF
public class FabricanteDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager em;

	public void salvar(Fabricante fabricante) {
		em.persist(fabricante);
	}
}
