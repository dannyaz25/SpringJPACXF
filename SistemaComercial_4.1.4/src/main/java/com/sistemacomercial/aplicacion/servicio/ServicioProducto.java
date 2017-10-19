package com.sistemacomercial.aplicacion.servicio;

import java.util.List;

import com.sistemacomercial.aplicacion.bo.Marca;
import com.sistemacomercial.aplicacion.bo.Producto;
import com.sistemacomercial.aplicacion.dao.MarcaDAO;
import com.sistemacomercial.aplicacion.dao.ProductoDAO;



public interface ServicioProducto {
		public ProductoDAO getProductoDAO();
		public void setProductoDAO(ProductoDAO productoDAO);
		public MarcaDAO getMarcaDAO();
		public void setMarcaDAO(MarcaDAO marcaDAO);
		public void insertarProducto(Producto producto);
		public void salvarProducto(Producto producto);
		public void borrarProducto(Producto producto);
		public List<Producto> buscarTodosLosProductos();
		public List<Marca> buscarMarcasProductos();
		public Producto buscarProductoPorCodigo(String codigo);
		public Marca buscarMarcaPorCodigo(String id);
		public List<Producto> buscarProductoPorMarca(Marca marca);
}
