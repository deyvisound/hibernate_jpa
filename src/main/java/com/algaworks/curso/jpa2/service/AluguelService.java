package com.algaworks.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.AluguelDAO;
import com.algaworks.curso.jpa2.modelo.Aluguel;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class AluguelService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AluguelDAO aluguelDao;
	
	@Transactional
	public void salvar(Aluguel aluguel) throws NegocioException {	
		validate(aluguel);
		
		aluguelDao.salvar(aluguel);
	}
		
	private void validate(Aluguel a) throws NegocioException {
		if(!a.getApoliceSeguro().getProtecaoCausasNaturais() 
				&& !a.getApoliceSeguro().getProtecaoRoubo() 
					&& !a.getApoliceSeguro().getProtecaoTerceiro()) {
			throw new NegocioException("Ao menos um tipo de sinistro deve está contemplado!");
			
		}
	}

}
