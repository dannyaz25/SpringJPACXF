package com.bean;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ColaMensajesTest {
	ColaMensajes colaLlena3;
    
	  @Before
	  public void setUp() throws Exception {
	    colaLlena3 = new ColaMensajes(3);
	    colaLlena3.insertarMensaje("1");
	    colaLlena3.insertarMensaje("2");
	    colaLlena3.insertarMensaje("3");
	  }
	 
	  @Test
	  public void testInsertarMensaje() {
	    List<String> listaEsperada = new ArrayList<String>();
	    listaEsperada.add("2");
	    listaEsperada.add("3");
	    listaEsperada.add("4");
	         
	    colaLlena3.insertarMensaje("4");
	    assertEquals(listaEsperada, colaLlena3.obtenerMensajes());
	  }
	 
	  @Test
	  public void testNumMensajes() {
	    assertEquals(3, colaLlena3.obtenerMensajes());
	  }
	 
	  @Test
	  public void testExtraerMensaje() {
	    assertEquals("1", colaLlena3.extraerMensaje());
	  }


}
