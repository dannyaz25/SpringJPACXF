package com.sistemacomercial.aplicacion.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


@Entity
@Table(name = "Marca")
public class Marca {
	@Id
	private String idMarca;
	private String descripcion;
	@OneToMany
	@JoinColumn(name = "marca")
	private List<Producto> listaProducto;
	public List<Producto> getListaProducto() {
	return listaProducto;
	}
	public void setListaDeLibros(List<Producto> listaProducto) {
	this.listaProducto = listaProducto;
	}
	public int hashCode() {
	return idMarca.hashCode();
	}
	
	@Override
	public boolean equals (Object o) {
	String marcaId= ((Marca)o).getIdMarca();
	return idMarca.equals(marcaId);
	}
	public String getIdMarca() {
	return idMarca;
	}
	public void setIdMarca(String id) {
	this.idMarca = id;
	}
	public String getDescripcion() {
	return descripcion;
	}
	public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
	}
	
	public Marca(String idMarca,String descripcion){
		this.idMarca=idMarca;
		this.descripcion=descripcion;
	}
	public Marca(){}
}
