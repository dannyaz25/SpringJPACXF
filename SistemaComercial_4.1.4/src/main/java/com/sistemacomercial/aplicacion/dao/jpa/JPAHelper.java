package com.sistemacomercial.aplicacion.dao.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAHelper {
	private static final EntityManagerFactory emf = buildEntityManagerFactory();
	
	private static EntityManagerFactory buildEntityManagerFactory() {
		try {
		return Persistence.createEntityManagerFactory("hablemosJava");
		}catch (Throwable ex) {
		throw new RuntimeException("Error al crear la factoria de JPA");
		}
	}
	public static EntityManagerFactory getJPAFactory() {
		return emf;
	}
	
		
}
