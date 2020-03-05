package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class ModeloCarroDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public ModeloCarro findByCodigo(Long codigo) {
		return manager.find(ModeloCarro.class, codigo);
	}
	
	public void salvar(ModeloCarro modeloCarro) {
		manager.merge(modeloCarro);
	}

	@SuppressWarnings("unchecked")
	public List<ModeloCarro> buscarTodos() {
		String qlString = "from ModeloCarro";
		return manager.createQuery(qlString).getResultList();
	}
	
	@Transactional
	public void excluir(ModeloCarro modeloCarro) throws NegocioException {
		modeloCarro = findByCodigo(modeloCarro.getCodigo());
		try {
			manager.remove(modeloCarro);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Este modelo não pode ser excluído.");
		}
	}
	
}
