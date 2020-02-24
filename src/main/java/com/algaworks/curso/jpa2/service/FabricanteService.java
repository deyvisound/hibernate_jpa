package com.algaworks.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.FabricanteDao;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class FabricanteService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FabricanteDao fabricanteDao;

	// Notação criada nas classes UTIL
	@Transactional
	public void salvar(Fabricante fabricante) throws NegocioException {
		this.validateCadastro(fabricante);

		this.fabricanteDao.salvar(fabricante);

	}

	private void validateCadastro(Fabricante fabricante) throws NegocioException {

		if (fabricante.getNome() == null || fabricante.getNome().trim().equals("")) {
			throw new NegocioException("O nome do fabricante não pode ser nulo!");
		}

	}
}
