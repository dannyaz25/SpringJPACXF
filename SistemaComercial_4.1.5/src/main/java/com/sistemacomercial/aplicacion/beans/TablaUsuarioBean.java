package com.sistemacomercial.aplicacion.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
@ManagedBean(name="tablaUsuarioBean", eager = true)
public class TablaUsuarioBean {
private List<Usuario> usuarios;

public List<Usuario> getUsuarios() {
	return usuarios;
}

public void setUsuarios(List<Usuario> usuarios) {
	this.usuarios = usuarios;
}
@PostConstruct
public void iniciar(){
	Usuario u=new Usuario("pedro",25);
	Usuario u2=new Usuario("christian",20);
	usuarios=new ArrayList<Usuario>();
	usuarios.add(u);
	usuarios.add(u2);
}
}
