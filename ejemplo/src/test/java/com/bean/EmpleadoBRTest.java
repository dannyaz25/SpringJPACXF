package com.bean;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmpleadoBRTest {

	TestableEmpleadoBR ebr;
	TestableEmpleadoBR ebrFail;
	@Before
	public void setUpClass() {
	  ebr = new TestableEmpleadoBR();
	  ebr.setProxyAeat(new MockProxyAeat(false));
	 
	  ebrFail = new TestableEmpleadoBR();
	  ebrFail.setProxyAeat(new MockProxyAeat(true));
	}
	@Test
	  public void testCalculaSalarioBruto1() {
	    float resultadoReal = EmpleadoBR.calculaSalarioBruto(
	                           TipoEmpleado.vendedor, 2000.0f, 8.0f);
	    float resultadoEsperado = 1360.0f;
	    assertEquals(resultadoEsperado, resultadoReal, 0.01);
	  }
	     
	  @Test
	  public void testCalculaSalarioBruto2() {
	    float resultadoReal = EmpleadoBR.calculaSalarioBruto(
	                           TipoEmpleado.vendedor, 1500.0f, 3.0f);
	    float resultadoEsperado = 1260.0f;
	    assertEquals(resultadoEsperado, resultadoReal, 0.01);
	  }
	 
	  @Test
	  public void testCalculaSalarioNeto1() {
	    float resultadoReal = EmpleadoBR.calculaSalarioNeto(2000.0f);
	    float resultadoEsperado = 1640.0f;
	    assertEquals(resultadoEsperado, resultadoReal, 0.01);
	  }
	 
	  @Test
	  public void testCalculaSalarioNeto2() {
	    float resultadoReal = EmpleadoBR.calculaSalarioNeto(1500.0f);
	    float resultadoEsperado = 1230.0f;
	    assertEquals(resultadoEsperado, resultadoReal, 0.01);
	  }
	  
	  @Test
	  public void testCalculaSalarioNeto3() throws BRException {
	    float resultadoReal = ebr.calculaSalarioNeto2(2000.0f);
	    float resultadoEsperado = 1640.0f;
	    assertEquals(resultadoEsperado, resultadoReal, 0.01);
	  }

}
