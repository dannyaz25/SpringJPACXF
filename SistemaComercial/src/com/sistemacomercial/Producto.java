package com.sistemacomercial;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Producto {
	 private String codigo;
	 private String descripcion;
	 private String marca;
	
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
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Producto(String codigo,String descripcion,String marca){
		this.codigo=codigo;
		this.descripcion=descripcion;
		this.marca=marca;
		
	}
	public Producto(){
		
	}

public static List<Producto> buscarTodos(){
	String consultaSQL="Select codigo,descripcion,marca from productos";
	DataBaseHelper<Producto> db=new DataBaseHelper<Producto>();
	List<Producto> listaProductos=db.seleccionarRegistros(consultaSQL, Producto.class);
	return listaProductos;
}
public static List<String> buscarTodosMarcas(){
	String consultaSQL="Select distinct(marca) from productos";
	DataBaseHelper<String> db=new DataBaseHelper<String>();
	List<String> listaMarcas=db.seleccionarRegistros(consultaSQL,String.class);
	return listaMarcas;
}
public static void insertarProductos(String codigo,String descripcion,String marca){
	String consultaSQL = "insert into productos (codigo,descripcion,marca) values ";
	consultaSQL += "('" + codigo + "','" + descripcion + "','" + marca + "')";
	DataBaseHelper db=new DataBaseHelper();
	db.editarRegistro(consultaSQL);
}
}
