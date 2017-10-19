package com.sistemacomercial.aplicacion.servicio;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistemacomercial.aplicacion.bo.Marca;
import com.sistemacomercial.aplicacion.bo.Producto;
import com.sistemacomercial.aplicacion.dao.MarcaDAO;
import com.sistemacomercial.aplicacion.dao.ProductoDAO;

@Service(value="servicioProductos")
public class ServicioProductoImpl implements ServicioProducto{
	
	private ProductoDAO productoDAO=null;
	private MarcaDAO marcaDAO=null;
	public ProductoDAO getProductoDAO() {
		return productoDAO;
	}
//	public ServicioProductoImpl(){
//	
//			ClassPathXmlApplicationContext factoria =
//			new ClassPathXmlApplicationContext("contextoAplicacion.xml");
//			productoDAO= (ProductoDAO)factoria.getBean("productoDAO");
//			marcaDAO=(MarcaDAO)factoria.getBean("marcaDAO");
//	}
	@Autowired
	public void setProductoDAO(ProductoDAO productoDAO) {
		this.productoDAO = productoDAO;
	}

	public MarcaDAO getMarcaDAO() {
		return marcaDAO;
	}
	@Autowired
	public void setMarcaDAO(MarcaDAO marcaDAO) {
		this.marcaDAO = marcaDAO;
	}




	
	

	@Transactional
		public void salvarProducto(Producto producto) {
			// TODO Auto-generated method stub
			productoDAO.salvar(producto);
		}

	@Transactional
		public void borrarProducto(Producto producto) {
			// TODO Auto-generated method stub
			productoDAO.borrar(producto);
		}

	@Transactional
		public List<Producto> buscarTodosLosProductos() {
			// TODO Auto-generated method stub
			return productoDAO.buscarTodos();
		}

	@Transactional
		public List<Marca> buscarMarcasProductos() {
			// TODO Auto-generated method stub
			return marcaDAO.buscarTodos();
		}

	@Transactional
		public Producto buscarProductoPorCodigo(String codigo) {
			// TODO Auto-generated method stub
			return productoDAO.buscarPorCodigo(codigo);
		}

	@Transactional
		public Marca buscarMarcaPorCodigo(String idMarca) {
			// TODO Auto-generated method stub
			return marcaDAO.buscarPorCodigo(idMarca);
		}

	@Transactional
		public List<Producto> buscarProductoPorMarca(Marca marca) {
			// TODO Auto-generated method stub
			return productoDAO.buscarPorMarca(marca);
		}




		@Override
		public void insertarProducto(Producto producto) {
			// TODO Auto-generated method stub
			 productoDAO.insertar(producto);
		}

		


}