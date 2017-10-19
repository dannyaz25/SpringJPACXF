package com.sistemacomercial.aplicacion.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T,Id extends Serializable> {
	T buscarPorCodigo (Id id);
	List<T>buscarTodos();
	void salvar(T objeto);
	void borrar(T objeto);
	void insertar(T objeto);
}
