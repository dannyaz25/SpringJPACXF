package com.bean;

import java.io.IOException;
import java.util.List;

public class EmpleadoBR {
	static float calculaSalarioBruto(TipoEmpleado tipo, float ventasMes,float horasExtra)
	{
		return 0.0f;
	}
	static float calculaSalarioNeto(float salarioBruto)
	{
		return 0.0f;
	}
	public float calculaSalarioNeto2(float salarioBruto) throws BRException {
		  float retencion = 0.0f;
		         
		  if(salarioBruto < 0) {
		    throw new BRException();
		  }
		         
		  ProxyAeat proxy = getProxyAeat();
		  List<TramoRetencion> tramos;
		  try {
		    tramos = proxy.getTramosRetencion();
		  } catch (IOException e) {
		    throw new BRException();
		  } 
		         
		  for(TramoRetencion tr: tramos) {
		    if(salarioBruto < tr.getLimiteSalario()) {
		      retencion = tr.getRetencion();
		      break;
		    }
		  }
		         
		  return salarioBruto * (1 - retencion); 
		}
		 
		ProxyAeat getProxyAeat() {
		  ProxyAeat proxy = new ProxyAeat();
		  return proxy;
		}
		
}
