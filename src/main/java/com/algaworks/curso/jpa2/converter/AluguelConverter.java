package com.algaworks.curso.jpa2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.AluguelDAO;
import com.algaworks.curso.jpa2.modelo.Aluguel;

public class AluguelConverter implements Converter {

	@Inject
	private AluguelDAO aDao;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String id) {			
		
		Aluguel a = aDao.findByCodigo(Long.valueOf(id)); 
		
		return a;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		String codigo = ((Aluguel)obj).getCodigo().toString();
		
		return codigo;
	}

}
