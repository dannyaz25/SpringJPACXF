package com.sistemacomercial.aplicacion.dao;

import java.util.List;


import com.sistemacomercial.aplicacion.bo.Marca;

public interface MarcaDAO {
	public abstract  List<Marca> buscarTodos();
	public abstract void borrar(Marca marca);
	public abstract void salvar(Marca marca);
	public abstract Marca buscarPorCodigo(String codigo);
}
