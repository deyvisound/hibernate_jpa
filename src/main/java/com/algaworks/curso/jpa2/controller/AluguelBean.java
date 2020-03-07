package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.CarroDAO;
import com.algaworks.curso.jpa2.modelo.Aluguel;
import com.algaworks.curso.jpa2.modelo.ApoliceSeguro;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.service.AluguelService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class AluguelBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Aluguel aluguel;

	private List<Carro> carros;
	
	@Inject
	private CarroDAO carroDao;
	
	@Inject
	private AluguelService aluguelSev;
	
	@PostConstruct
	public void inicializar() {
		this.limpar();		
		this.carros = carroDao.findAll();
		
	}
	
	private void limpar() {
		this.aluguel = new Aluguel();
		this.aluguel.setApoliceSeguro(new ApoliceSeguro());		
	}

	public void salvar() {
		try {				
			this.aluguelSev.salvar(this.aluguel);
			FacesUtil.addSuccessMessage("Aluguel cadastrado com sucesso!");
		}catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
		this.limpar();
	}

	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

}
