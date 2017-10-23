package com.bean;

public class TestableEmpleadoBR extends EmpleadoBR{
	 ProxyAeat proxy;
     
	  public void setProxyAeat(ProxyAeat proxy) {
	    this.proxy = proxy;
	  }
	     
	  @Override
	  ProxyAeat getProxyAeat() {
	    return proxy;
	  }
}
