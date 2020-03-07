package com.algaworks.curso.jpa2.config;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Acessorio;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import com.algaworks.curso.jpa2.util.jpa.EntityManagerProducer;

public class PopularBanco {

	public static void main(String[] args) {
		
		EntityManagerProducer ep = new EntityManagerProducer();
		EntityManager em = ep.create();
		
		
		///FABRICANTES: 
		
		Fabricante f = new Fabricante();
		f.setNome("FORD");
		
		Fabricante f2 = new Fabricante();
		f2.setNome("RENAULT");
		
		Fabricante f3 = new Fabricante();
		f3.setNome("FIAT");
		
		Fabricante f4 = new Fabricante();
		f4.setNome("CHEVROLET");
		
		
		///MODELOS:   
		
			//FORD: 
		ModeloCarro mc = new ModeloCarro();		
		mc.setFabricante(f);
		mc.setDescricao("Ka");
		
		ModeloCarro mc2 = new ModeloCarro();		
		mc2.setFabricante(f);
		mc2.setDescricao("Focus");
		
		ModeloCarro mc3 = new ModeloCarro();		
		mc3.setFabricante(f);
		mc3.setDescricao("Fiesta");
		
		ModeloCarro mc4 = new ModeloCarro();		
		mc4.setFabricante(f);
		mc4.setDescricao("Mustang");
		
			//RENALT
		ModeloCarro mc5 = new ModeloCarro();		
		mc5.setFabricante(f2);
		mc5.setDescricao("Clio");
		
		ModeloCarro mc6 = new ModeloCarro();		
		mc6.setFabricante(f2);
		mc6.setDescricao("Megane");
		
		ModeloCarro mc7 = new ModeloCarro();		
		mc7.setFabricante(f2);
		mc7.setDescricao("Logan");
		
		ModeloCarro mc8 = new ModeloCarro();		
		mc8.setFabricante(f2);
		mc8.setDescricao("Dust");
		
			//FIAT
		ModeloCarro mc9 = new ModeloCarro();		
		mc9.setFabricante(f3);
		mc9.setDescricao("Uno");
		
		ModeloCarro mc10 = new ModeloCarro();		
		mc10.setFabricante(f3);
		mc10.setDescricao("Siena");
		
		ModeloCarro mc11 = new ModeloCarro();		
		mc11.setFabricante(f3);
		mc11.setDescricao("Palio");
		
			//CHEVROLET
		ModeloCarro mc12 = new ModeloCarro();		
		mc12.setFabricante(f4);
		mc12.setDescricao("Corsa");
		
		ModeloCarro mc13 = new ModeloCarro();		
		mc13.setFabricante(f4);
		mc13.setDescricao("Prisma");	
		
		// ACESSÓRIOS: 
		
		Acessorio ac = new Acessorio();
		ac.setDescricao("Ar Condicionado");
		
		Acessorio ac2 = new Acessorio();
		ac2.setDescricao("Direção Hidráulica");
		
		Acessorio ac3 = new Acessorio();
		ac3.setDescricao("Vidro Elérico");
		
		Acessorio ac4 = new Acessorio();
		ac4.setDescricao("Air Bang");
		
		
		em.getTransaction().begin();
		em.persist(f);
		em.persist(f2);
		em.persist(f3);
		em.persist(f4);
		
		em.persist(mc);
		em.persist(mc2);
		em.persist(mc3);
		em.persist(mc4);
		em.persist(mc5);
		em.persist(mc6);
		em.persist(mc6);
		em.persist(mc7);
		em.persist(mc8);
		em.persist(mc9);
		em.persist(mc10);
		em.persist(mc11);
		em.persist(mc12);
		em.persist(mc13);
		
		em.persist(ac);
		em.persist(ac2);
		em.persist(ac3);
		em.persist(ac4);
		
		em.getTransaction().commit();
	}

}
