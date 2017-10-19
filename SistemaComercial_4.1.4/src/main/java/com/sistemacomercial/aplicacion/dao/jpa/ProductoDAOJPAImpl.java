package com.sistemacomercial.aplicacion.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sistemacomercial.aplicacion.bo.Marca;
import com.sistemacomercial.aplicacion.bo.Producto;
import com.sistemacomercial.aplicacion.dao.ProductoDAO;
import com.sistemacomercial.aplicacion.dao.jpa.JPAHelper;
@Repository
public class ProductoDAOJPAImpl extends GenericDAOJPAImpl<Producto,String> implements ProductoDAO {

	public  List<Producto> buscarPorMarca(Marca marca){
		//EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
	//	EntityManager manager = getEntityManagerFactory().createEntityManager();
		TypedQuery<Producto> consulta=getManager().createQuery("select p from Producto p where p.marca=?1",Producto.class);
		consulta.setParameter(1, marca);	
		List<Producto> lista = null;
		lista=consulta.getResultList();
		//manager.close();		
				 return lista;
	}

}
