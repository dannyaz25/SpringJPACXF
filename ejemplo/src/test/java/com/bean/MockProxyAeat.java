package com.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MockProxyAeat extends ProxyAeat {
	 boolean lanzarExcepcion;
     
	  public MockProxyAeat(boolean lanzarExcepcion) {
	    this.lanzarExcepcion = lanzarExcepcion;     
	  }
	     
	  @Override
	  public List<TramoRetencion> getTramosRetencion() 
	                                             throws IOException {
	    if(lanzarExcepcion) {
	      throw new IOException("Error al conectar al servidor");
	    }	
	 
	    List<TramoRetencion> tramos = new ArrayList<TramoRetencion>();
	    tramos.add(new TramoRetencion(1000.0f, 0.0f));
	    tramos.add(new TramoRetencion(1500.0f, 0.16f));
	    tramos.add(new TramoRetencion(Float.POSITIVE_INFINITY, 0.18f));
	         
	    return tramos;
	  }
}
