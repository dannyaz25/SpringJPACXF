<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--import para jdbc-->
<%@ page import="com.sistemacomercial.Producto" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>	
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar Productos</title>
</head>
<body>
<select name="comboMarca">
<option value="0">seleccionar</option>
<%

	
		List<String> listaCategorias=null;
		listaCategorias=Producto.buscarTodosMarcas();
		for(String categoria:listaCategorias) { %>
		

	<option value="<%=categoria%>"><%=categoria%></option>	

		<% 
		}
%>
</select>
<br>
<%

	
	List<Producto> listaProductos=null;
		listaProductos=Producto.buscarTodos();
		for(Producto producto:listaProductos) { %>
		<%=producto.getCodigo()%>
		<%=producto.getDescripcion()%>
		<%=producto.getMarca()%>
		<br/>
<% 
		}
%>
<a href="FormProductosInicio.jsp">Insertar Producto</a>	
</body>
</html>