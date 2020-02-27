package com.algaworks.curso.jpa2.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.FabricanteDao;
import com.algaworks.curso.jpa2.modelo.Fabricante;

public class FabricanteService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FabricanteDao fabricanteDao;
	
	public void salvar(Fabricante fabricante) throws NegocioException {
		this.validateCadastro(fabricante);

		this.fabricanteDao.salvar(fabricante);
	}

	private void validateCadastro(Fabricante fabricante) throws NegocioException {

		if (fabricante.getNome() == null || fabricante.getNome().trim().equals("")) {
			throw new NegocioException("O nome do fabricante não pode ser nulo!");
		}

	}

	public List<Fabricante> buscarTodos() {
		return fabricanteDao.buscarTodos();
	}

	public void excluir(Fabricante fabricante) throws NegocioException {	
		try {
			this.fabricanteDao.excluir(fabricante);
		}catch (Exception e) {
			throw new NegocioException("Falha ao excluir Fabricante: " + e.getMessage());
		}		
	}

	public void atualizar(Fabricante fabricante) throws NegocioException {
		this.validateCadastro(fabricante);

		this.fabricanteDao.atualizar(fabricante);		
	}
}
