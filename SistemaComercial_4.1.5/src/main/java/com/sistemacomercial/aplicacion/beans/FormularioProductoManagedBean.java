package com.sistemacomercial.aplicacion.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.sistemacomercial.aplicacion.bo.Marca;
import com.sistemacomercial.aplicacion.bo.Producto;
import com.sistemacomercial.aplicacion.servicio.ServicioProducto;

@ManagedBean
@SessionScoped
public class FormularioProductoManagedBean {
	private String codigo;
	private String descripcion;
	private String marca;
	private List<SelectItem> listaDeMarcas;
	private List<Producto> listaDeProductos;
	@ManagedProperty("#{servicioProductos}")
	private ServicioProducto servicioProductos;
	public void setServicioProductos(ServicioProducto servicioProductos) {
		this.servicioProductos = servicioProductos;
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
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public List<SelectItem> getListaDeMarcas() {
		return listaDeMarcas;
	}
	public void setListaDeMarcas(List<SelectItem> listaDeMarcas) {
		this.listaDeMarcas = listaDeMarcas;
	}
	public List<Producto> getListaDeProductos() {
		return listaDeProductos;
	}
	public void setListaDeProductos(List<Producto> listaDeProductos) {
		this.listaDeProductos = listaDeProductos;
	}
	public ServicioProducto getServicioProductos() {
		return this.servicioProductos;
//		ApplicationContext contexto = FacesContextUtils
//		.getWebApplicationContext(FacesContext.getCurrentInstance());
//		return (ServicioProducto) contexto.getBean("servicioProductos");
	}
	@PostConstruct
	public void iniciar() {
		listaDeProductos = getServicioProductos().buscarTodosLosProductos();
		List<Marca> marcas = getServicioProductos().buscarMarcasProductos();
		listaDeMarcas = new ArrayList<SelectItem>();
		for (Marca marca : marcas) {
		listaDeMarcas.add(new SelectItem(marca.getIdMarca(),marca.getDescripcion()));
		}
	}
	public void insertar(ActionEvent evento) {
		getServicioProductos().insertarProducto(
		new Producto(codigo, descripcion, new Marca(marca,null)));
		setListaDeProductos(getServicioProductos().buscarTodosLosProductos());
		marca="0";
		}
	public void borrar(String codigo) {
		getServicioProductos().borrarProducto(new Producto(codigo));
		setListaDeProductos(getServicioProductos().buscarTodosLosProductos());
		}
	public void filtrar(ValueChangeEvent evento) {
		String idMarca = evento.getComponent().getAttributes().get("value").toString();
			if(!idMarca.equals("0"))
			{
			setListaDeProductos(getServicioProductos().
			buscarProductoPorMarca(new Marca(idMarca,null)));
			}else {
				setListaDeProductos(getServicioProductos().
						buscarTodosLosProductos());
			}
		}
	public void editar(String codigo) {
		Producto producto = getServicioProductos().buscarProductoPorCodigo(codigo);	
		this.codigo = producto.getCodigo();
		this.descripcion = producto.getDescripcion();
		this.marca=producto.getMarca().getIdMarca();
		
	}
	public void formularioInsertar(ActionEvent evento) {
		this.codigo = "";
		this.descripcion = "";
	}
	public void salvar(ActionEvent evento) {
		getServicioProductos().salvarProducto(
		new Producto(codigo, descripcion, new Marca(marca,null)));
		setListaDeProductos(getServicioProductos().buscarTodosLosProductos());
		marca="0";
		}
	
}
