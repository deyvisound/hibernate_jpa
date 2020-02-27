package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

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
	
	private Fabricante fabricanteSelecionado;
	
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
	

	public Fabricante getFabricanteSelecionado() {
		return fabricanteSelecionado;
	}

	public void setFabricanteSelecionado(Fabricante fabricanteSelecionado) {
		this.fabricanteSelecionado = fabricanteSelecionado;
	}
	
	public void salvar() {
		try {
			if(fabricante.getCodigo() == null) {
				this.fabricanteSev.salvar(fabricante);
				FacesUtil.addSuccessMessage("Fabricante Salvo com Sucesso!");
			}else {				
				this.fabricanteSev.atualizar(fabricante);
				FacesUtil.addSuccessMessage("Fabricante atualizado com Sucesso!");
			}
			 
			
			this.limpar();
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public void excluir() {
		try {
			this.fabricanteSev.excluir(fabricanteSelecionado);
			FacesUtil.addSuccessMessage("Fabricante excluído com Sucesso!"); 
			
			this.limpar();
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public List<Fabricante> getAllFabricantes() {
		return this.fabricanteSev.buscarTodos();		
	}
	
}
