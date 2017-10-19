package com.sistemacomercial.aplicacion.servicio.externo;

public class ProductoDTO {
	private String codigo;
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
	private String descripcion;
	private String marca;
	public ProductoDTO(String codigo,String descripcion,String marca){
		this.codigo=codigo;
		this.descripcion=descripcion;
		this.marca=marca;
	}
}
