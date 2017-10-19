package com.sistemacomercial.aplicacion.beans;


import javax.faces.bean.ManagedBean;

@ManagedBean(name = "usuarioBean", eager = true)
public class UsuarioBean {
	private String nombre;
	public String getNombre() {
	return nombre;
	}
	public void setNombre(String nombre) {
	this.nombre = nombre;
	}
	public String getMessage() {
	      return "Hello World!";
	   }

}
