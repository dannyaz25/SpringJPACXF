package com.sistemacomercial.aplicacion.beans;

public class Usuario {
	private String nombre;
	private int edad;
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
		}
		public void setNombre(String nombre) {
		this.nombre = nombre;
		}
		public Usuario(String nombre,int edad){
			super();
			this.nombre=nombre;
			this.edad=edad;
		}
}
