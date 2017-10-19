package com.sistemacomercial.aplicacion.dao.jpa;

import java.io.Serializable;
import java.util.List;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sistemacomercial.aplicacion.dao.GenericDAO;
@Repository
public abstract class GenericDAOJPAImpl<T, Id extends Serializable>  implements GenericDAO<T, Id>  {
	private Class<T> claseDePersistencia;

	//private EntityManagerFactory entityManagerFactory;	
	@PersistenceContext
    private EntityManager manager;
	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	@SuppressWarnings("unchecked")
	public GenericDAOJPAImpl() {
	this.claseDePersistencia = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
//	public EntityManagerFactory getEntityManagerFactory() {
//		return entityManagerFactory;
//		}
//	public void setEntityManagerFactory(EntityManagerFactory
//		entityManagerFactory) {
//		this.entityManagerFactory = entityManagerFactory;
//		}
	
	@Override
	public T buscarPorCodigo(Id id) {
			//EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
			//EntityManager manager = factoriaSession.createEntityManager();
//		EntityManager manager =getEntityManagerFactory().createEntityManager();
//			T objeto = null;
//					try {
//					objeto = (T) manager.find(claseDePersistencia, id);
//					return objeto;
//					} finally {
//					manager.close();
//					}
		return getManager().find(claseDePersistencia, id);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<T> buscarTodos() {
			//EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
			
		//EntityManager manager =getEntityManagerFactory().createEntityManager(); //factoriaSession.createEntityManager();
			List<T> listaDeObjetos = null;
			//try {
			TypedQuery<T> consulta = manager.createQuery("select o from "
			+ claseDePersistencia.getSimpleName()+ " o",
			claseDePersistencia);
			listaDeObjetos = consulta.getResultList();
			return listaDeObjetos;
			//} finally {
			//manager.close();
			//}
	}

	@Transactional
	public void borrar(T objeto) {
		getManager().remove(getManager().merge(objeto));
//			EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
//			EntityManager manager = factoriaSession.createEntityManager();
//		EntityManager manager =getEntityManagerFactory().createEntityManager();
//			EntityTransaction tx = null;
//			try {
//			tx = manager.getTransaction();
//			tx.begin();
//			manager.remove(manager.merge(objeto));
//			tx.commit();
//			} catch (PersistenceException e) {
//			tx.rollback();
//			throw e;
//			} finally {
//			manager.close();
//			}
	}
	@Transactional
	public void salvar(T objeto) {
		getManager().merge(objeto);
//			EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
//			EntityManager manager = factoriaSession.createEntityManager();
//		EntityManager manager =getEntityManagerFactory().createEntityManager();
//			EntityTransaction tx = null;
//			try {
//			tx = manager.getTransaction();
//			tx.begin();
//			manager.merge(objeto);
//			tx.commit();
//			} catch (PersistenceException e) {
//			tx.rollback();
//			throw e;
//			} finally {
//			manager.close();
//			}
	}
	@Transactional 
	public void insertar(T objeto) {
		getManager().persist(objeto);
//			EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
//			EntityManager manager = factoriaSession.createEntityManager();
//		EntityManager manager =getEntityManagerFactory().createEntityManager();
//			EntityTransaction tx = null;
//			try {
//			tx = manager.getTransaction();
//			tx.begin();
//			manager.persist(objeto);
//			tx.commit();
//			} catch (PersistenceException e) {
//			tx.rollback();
//			throw e;
//			} finally {
//			manager.close();
//			}
	}
	
}
