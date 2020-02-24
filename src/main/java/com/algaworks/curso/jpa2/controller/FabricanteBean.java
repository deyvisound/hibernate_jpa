package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.service.FabricanteService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@SuppressWarnings("serial")
@Named
@ViewScoped 
public class FabricanteBean implements Serializable {
	
	@Inject
	private FabricanteService fabricanteSev;
	
	private Fabricante fabricante;
	
	@PostConstruct
	public void init() {
		this.limpar();
	}

	private void limpar() {
		this.fabricante = new Fabricante();
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	
	public void salvar() {
		try {
			this.fabricanteSev.salvar(fabricante);
			FacesUtil.addSuccessMessage("Fabricante Salvo com Sucesso!"); 
			
			this.limpar();
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
}
