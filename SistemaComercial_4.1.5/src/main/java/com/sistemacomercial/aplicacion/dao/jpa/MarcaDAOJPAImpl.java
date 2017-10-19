package com.sistemacomercial.aplicacion.dao.jpa;

import org.springframework.stereotype.Repository;

import com.sistemacomercial.aplicacion.bo.Marca;
import com.sistemacomercial.aplicacion.dao.MarcaDAO;
@Repository
public class MarcaDAOJPAImpl extends GenericDAOJPAImpl<Marca, String> implements MarcaDAO{
	
}
