package com.sistemacomercial.aplicacion.dao;

import java.util.List;


import com.sistemacomercial.aplicacion.bo.Marca;
import com.sistemacomercial.aplicacion.bo.Producto;


public interface ProductoDAO {
	public abstract  List<Producto> buscarTodos();
	public abstract void insertar(Producto producto);
	public abstract void borrar(Producto producto);
	public abstract void salvar(Producto producto);
	public abstract Producto buscarPorCodigo(String codigo);
	public abstract   List<Producto> buscarPorMarca(Marca marca);
}
