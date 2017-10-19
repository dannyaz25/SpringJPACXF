package com.sistemacomercial.aplicacion.servicio.externo.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemacomercial.aplicacion.bo.Producto;
import com.sistemacomercial.aplicacion.servicio.ServicioProducto;
import com.sistemacomercial.aplicacion.servicio.externo.ProductoDTO;
import com.sistemacomercial.aplicacion.servicio.externo.ServicioInformacionProducto;
@Service
@WebService(endpointInterface="com.sistemacomercial.aplicacion.servicio.externo.ServicioInformacionProducto")
public class ServicioInformacionProductoCXF implements ServicioInformacionProducto{


	private ServicioProducto servicioProductos;
	@Autowired
	public void setServicioProductos(ServicioProducto servicioProductos) {
		this.servicioProductos = servicioProductos;
	}
	public ServicioProducto getServicioProductos() {
		return this.servicioProductos;
		}
	@WebMethod
	public List<ProductoDTO> listaInformacionLibros() {
		// TODO Auto-generated method stub
		List<Producto> listaProductos=servicioProductos.buscarTodosLosProductos();
		List<ProductoDTO> listaDestino=new ArrayList<ProductoDTO>();
		for(Producto producto:listaProductos){
			ProductoDTO listaExterior=new ProductoDTO(producto.getCodigo(),producto.getDescripcion(),producto.getMarca().getDescripcion());
			listaDestino.add(listaExterior);
		}
		return listaDestino;
	}

}
