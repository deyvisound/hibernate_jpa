package com.algaworks.curso.jpa2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Fabricante.class)
public class FabricanteConverter implements Converter {
	
	private FabricanteDAO fDao;
	
	public FabricanteConverter() {
		this.fDao = CDIServiceLocator.getBean(FabricanteDAO.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String pk) {
		
		Fabricante f = fDao.findByCodigo(Long.valueOf(pk));
		
		return f;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Fabricante) value).getCodigo();
			return codigo == null ? null : codigo.toString();
		}
		return "";
	}

}
