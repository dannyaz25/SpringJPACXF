package com.sistemacomercial.aplicacion.bo;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Entity;
import com.sistemacomercial.aplicacion.bo.Producto;


@Entity
@Table(name="Productos")
public class Producto implements Serializable{
	@Id
	 private String codigo;
	 private String descripcion;
	 @ManyToOne
	 @JoinColumn (name="marca")
	 private Marca marca;
	
	 @Override
	 public int hashCode() {
	 return codigo.hashCode();
	 }
	 @Override
	 public boolean equals (Object o) {
	 String isbnLibro= ((Producto)o).getCodigo();
	 return isbnLibro.equals(codigo);
	 }
	 public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public Producto(String codigo,String descripcion,Marca marca){
		this.codigo=codigo;
		this.descripcion=descripcion;
		this.marca=marca;
		
	}
	public Producto(String codigo){
		this.codigo=codigo;
		
	}
	public Producto(){
		
	}


	
}
