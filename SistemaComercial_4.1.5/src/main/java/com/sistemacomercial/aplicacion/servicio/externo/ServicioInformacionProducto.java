package com.sistemacomercial.aplicacion.servicio.externo;

import java.util.List;

import javax.jws.WebService;


@WebService
public interface ServicioInformacionProducto {
	public List<ProductoDTO> listaInformacionLibros();

}
